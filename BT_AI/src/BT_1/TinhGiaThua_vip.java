package BT_1;

public class TinhGiaThua_vip {
    //Kỹ thuật đang dùng là "nhân bội thủ công và xử lý dãy số" hoặc "tính toán số lớn bằng mảng".
    /*
    1. Biểu diễn số lớn bằng mảng: Thay vì dùng kiểu dữ liệu nguyên thủy như int hay long không đủ khả năng lưu trữ các số rất lớn, ta sử dụng một mảng để lưu từng chữ số của kết quả. Mỗi phần tử trong mảng đại diện cho một chữ số của số lớn.
    2. Nhân từng bước và quản lý số dư (carry): Quá trình nhân bội được thực hiện từng bước, giữ lại kết quả của phép nhân giữa từng chữ số và số hiện tại, sau đó xử lý phần dư (carry) khi kết quả phép nhân lớn hơn 9.
    3. Xử lý số học thủ công: Bởi vì không sử dụng thư viện, toàn bộ phép toán số học như nhân và cộng với số dư phải được thực hiện thủ công thông qua các phép toán cơ bản trên từng chữ số của số lớn.
    */

    static int multiply(int x, int res[], int res_size) {
        int carry = 0;

        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;
            carry = prod / 10;
        }

        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    static void giaiThua(int n) {
        int[] res = new int[500];
        res[0] = 1;
        int res_size = 1;

        for (int x = 2; x <= n; x++) {
            res_size = multiply(x, res, res_size);
        }

        System.out.print("Giai thừa của " + n + "! là: ");
        for (int i = res_size - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        giaiThua(200);
    }

}
