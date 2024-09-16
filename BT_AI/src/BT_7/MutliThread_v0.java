package BT_7;

import java.util.Random;
import java.util.concurrent.*;

public class MutliThread_v0 {
    final static String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    // Hàm sinh chuỗi ngẫu nhiên với độ dài lớn
    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Thông số
        final int totalLength = 100000; // Độ dài tổng của chuỗi siêu lớn
        final int chunkSize = 100000; // Độ dài của mỗi phần nhỏ
        final int numberOfChunks = totalLength / chunkSize; // Số phần nhỏ cần sinh

        //đơn tiến trình
        long startTimeSingle = System.currentTimeMillis();
        StringBuilder randomString = new StringBuilder(totalLength);
        Random random = new Random();

        for (int i = 0; i < totalLength; i++) {
            randomString.append(characters.charAt(random.nextInt(characters.length())));

        }
        System.out.println(randomString);
        long endTimeSingle = System.currentTimeMillis();

        //đa tiến trình
        // Tạo ExecutorService với số lượng luồng
        ExecutorService executor = Executors.newFixedThreadPool(50);

        // Ghi lại thời gian bắt đầu
        long startTime = System.currentTimeMillis();

        // Tạo các tác vụ để sinh chuỗi cho từng phần nhỏ
        Future<String>[] futures = new Future[numberOfChunks];
        for (int i = 0; i < numberOfChunks; i++) {
            final int length = chunkSize; // Độ dài của phần nhỏ
            futures[i] = executor.submit(() -> generateRandomString(length));
        }

        // Kết hợp các phần nhỏ lại thành một chuỗi lớn
        StringBuilder finalString = new StringBuilder(totalLength);

        // Nhận và kết hợp kết quả từ các Future
        for (Future<String> future : futures) {
            try {
                String chunk = future.get(); // Lấy chuỗi phần nhỏ từ Future
                finalString.append(chunk); // Kết hợp phần nhỏ vào chuỗi lớn
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Ghi lại thời gian kết thúc
        long endTime = System.currentTimeMillis();
        long duration_single = endTimeSingle - startTimeSingle;
        long duration_mutli = endTime - startTime; // Thời gian chạy (ms)

        // In ra một phần đầu của chuỗi lớn để kiểm tra
        System.out.println("Chuỗi lớn được sinh ra: " + finalString);
        System.out.println("Thời gian chạy đơn : " + duration_single + " ms");
        System.out.println("Thời gian chạy đa: " + duration_mutli + " ms");

        // Đóng ExecutorService
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.HOURS);
    }
}
