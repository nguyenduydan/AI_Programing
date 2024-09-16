package BT_1;
import java.math.BigInteger;

public class TinhGiaThua_v1 {
    public static BigInteger giaiThua(int n){
        if(n == 1) return BigInteger.ONE;
        return BigInteger.valueOf(n).multiply(giaiThua(n - 1));
    }
    public static void main(String[] args) {
        System.out.println(giaiThua(100));
    }
}
