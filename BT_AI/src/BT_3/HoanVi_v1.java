package BT_3;

import java.util.Scanner;

public class HoanVi_v1 {
    // Hàm hoán vị các phần tử từ chỉ số start đến cuối mảng
    public static void generatePermutations(int[] arr, int start, int n) {
        if (start == n - 1) {
            // Khi chỉ số start đến cuối, in ra một hoán vị
            printArray(arr);
        } else {
            // Duyệt qua tất cả các phần tử từ vị trí start đến cuối
            for (int i = start; i < n; i++) {
                // Hoán đổi phần tử tại vị trí start với phần tử tại vị trí i
                swap(arr, start, i);

                // Gọi đệ quy để sinh tiếp các hoán vị cho phần còn lại
                generatePermutations(arr, start + 1, n);

                // Hoán đổi lại để phục hồi mảng như ban đầu (backtrack)
                swap(arr, start, i);
            }
        }
    }

    // Hàm hoán đổi 2 phần tử trong mảng
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Hàm in mảng
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập số N từ người dùng
        System.out.print("Nhập giá trị N: ");
        int N = scanner.nextInt();

        // Tạo mảng chứa các số từ 1 đến N
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        // Gọi hàm để sinh ra các hoán vị
        generatePermutations(arr, 0, N);

        scanner.close();
    }
}
