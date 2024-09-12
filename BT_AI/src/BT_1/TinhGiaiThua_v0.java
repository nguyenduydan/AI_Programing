package BT_1;

public class TinhGiaiThua_v0 {

    // Dùng cách để quy để tính
    static long giaiThua(int n){
        if(n==1) return 1;
        return n * giaiThua(n-1);
    }
    public static void main(String[] args) {
        System.out.println(giaiThua(10));
    }
}
