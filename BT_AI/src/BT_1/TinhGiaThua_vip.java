package BT_1;

public class TinhGiaThua_vip {
    //Kỹ thuật đang dùng là "nhân bội thủ công và xử lý dãy số" hoặc "tính toán số lớn bằng mảng".
    /*
    1. Biểu diễn số lớn bằng mảng: Thay vì dùng kiểu dữ liệu nguyên thủy như int hay long không đủ khả năng lưu trữ các số rất lớn, ta sử dụng một mảng để lưu từng chữ số của kết quả. Mỗi phần tử trong mảng đại diện cho một chữ số của số lớn.
    2. Nhân từng bước và quản lý số dư (carry): Quá trình nhân bội được thực hiện từng bước, giữ lại kết quả của phép nhân giữa từng chữ số và số hiện tại, sau đó xử lý phần dư (carry) khi kết quả phép nhân lớn hơn 9.
    3. Xử lý số học thủ công: Bởi vì không sử dụng thư viện, toàn bộ phép toán số học như nhân và cộng với số dư phải được thực hiện thủ công thông qua các phép toán cơ bản trên từng chữ số của số lớn.
    */
    // Function to multiply a number by the result stored in an array
    static int multiply(int x, int res[], int res_size) {
        int carry = 0;

        // Multiply x with every element in res[]
        for (int i = 0; i < res_size; i++) {
            int prod = res[i] * x + carry;
            res[i] = prod % 10;  // Store the last digit of prod in res[]
            carry = prod / 10;   // Put the rest in carry
        }

        // Put the remaining carry in res[]
        while (carry != 0) {
            res[res_size] = carry % 10;
            carry = carry / 10;
            res_size++;
        }
        return res_size;
    }

    // Function to calculate factorial and store digits in an array
    static void giaiThua(int n) {
        int[] res = new int[500];  // Array to store digits of the result
        res[0] = 1;  // Initialize the result as 1
        int res_size = 1;

        // Multiply the result with numbers from 2 to n
        for (int x = 2; x <= n; x++) {
            res_size = multiply(x, res, res_size);
        }

        // Print the factorial number stored in reverse order
        System.out.print("Factorial of " + n + " is: ");
        for (int i = res_size - 1; i >= 0; i--) {
            System.out.print(res[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        giaiThua(100);
    }

}
