package BT_2;
import java.math.BigInteger;
import java.util.Scanner;

public class NhiPhan_v1 {
    public static void tinhNhiPhan(int N){
        //tạo số nhị phân lớn nhất 2^N - 1
        BigInteger total = BigInteger.valueOf(2).pow(N);

        //tạo vòng lặp từ 0 -> 2^N - 1
        for(BigInteger i = BigInteger.ZERO; i.compareTo(total) < 0; i = i.add(BigInteger.ONE)){
            //chuyển số i thành số nhị phân
            String binaryString = i.toString(2);

            // Đảm bảo chuỗi có đúng N ký tự bằng cách thêm các số 0 ở phía trước
            while (binaryString.length() < N) {
                binaryString = "0" + binaryString;
            }

            // In chuỗi nhị phân
            System.out.println(binaryString);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài N: ");
        int n = scanner.nextInt();
        tinhNhiPhan(n);
    }
}
