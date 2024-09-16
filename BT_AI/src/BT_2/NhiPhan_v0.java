package BT_2;

import java.util.Scanner;

public class NhiPhan_v0 {

    public static void tinhNhiPhan(int n, String string) {
        if (n == 0){
            System.out.println(string);
            return;
        }

        tinhNhiPhan(n-1,string + "0");
        tinhNhiPhan(n-1,string + "1");

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập độ dài N: ");
        int n = scanner.nextInt();
        tinhNhiPhan(n, "");
    }
}
