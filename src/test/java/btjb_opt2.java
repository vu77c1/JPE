import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class btjb_opt2 {
    public static void main(String[] args) {
        //veTamGiac(6);
        //System.out.println(tinhTong(2));
        // System.out.println(tinhTongGiaiThua(3));
        //tinhTongTichVaInKetQua(234);
        // inUocSoChungBoiSoChung(3,5);
        // chuyenSangHeNhiPhan(30);
        // daoNguocChuoi("A b C");
        //inBangTanSoXuatHien("Helloworld");
        trichChuoiCon();


    }

    /*
        1.	Viết chương trình in ra các dấu * theo cấu trúc như sau (cho n là chiều cao của tháp tam giác, cần in ra n dòng):
        Ví dụ : n = 6
     */
    public static void veTamGiac(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /*
        2.	Viết chương trình tính :
        S=1+1/2+1/3+....+1/n
    */
    public static double tinhTong(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }

    /*
    3 Viết chương trình tính  :
        S = 1+1/3!+1/5!+…..+1/(2n-1)!
        Số n được nhập từ bàn phím
     */
    public static int tinhGiaiThua(int num) {
        if (num == 0 || num == 1) {
            return 1;
        } else {
            return num * tinhGiaiThua(num - 1);
        }
    }

    public static double tinhTongGiaiThua(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / tinhGiaiThua(2 * i - 1);
        }
        return sum;
    }

    /*
    4. Tính tổng và tích các chữ số của một số m, m được nhập từ bàn phím
    (Ví dụ : m = 234 => S = 2 + 3 + 4 = 9, P = 2 * 3 * 4 = 24)

     */
    public static void tinhTongTichVaInKetQua(int number) {
        Stack<Integer> stack = new Stack<>();

        // Đưa các chữ số vào ngăn xếp
        while (number > 0) {
            int chuSo = number % 10;
            stack.push(chuSo);
            number /= 10;
        }

        // Tính tổng và tích từ ngăn xếp
        int tong = 0;
        int tich = 1;

        while (!stack.isEmpty()) {
            int chuSo = stack.pop();
            tong += chuSo;
            tich *= chuSo;
        }

        // In kết quả
        System.out.println("Tổng các chữ số là: " + tong);
        System.out.println("Tích các chữ số là: " + tich);
    }

    /*
       5. Nhập 2 số nguyên dương a và b. Sau đó in ra ước số chung lớn nhất và bội số chung nhỏ nhất của 2 số nguyên dương a và b đó.
     */
    public static void inUocSoChungBoiSoChung(int a, int b) {
        int uscln = timUSCLN(a, b);
        int bscnn = timBSCNN(a, b);

        // In kết quả
        System.out.println("Ước số chung lớn nhất của " + a + " và " + b + " là: " + uscln);
        System.out.println("Bội số chung nhỏ nhất của " + a + " và " + b + " là: " + bscnn);
    }

    public static int timUSCLN(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int timBSCNN(int a, int b) {
        return (a * b) / timUSCLN(a, b);
    }

    /*
    6. Viết chương nhập vào một số nguyên dương n. Sau đó quy đổi n ra hệ nhị phân.
     */
    public static void chuyenSangHeNhiPhan(int number) {
        Stack<Integer> stack = new Stack<>();
        while (number > 0) {
            int soDu = number % 2;
            stack.push(soDu);
            number /= 2;
        }
        ;
        while (!stack.isEmpty()) {
            int chuSo = stack.pop();
            System.out.print(chuSo);
        }
    }

    /*
      7.  Nhập vào một String S,  thực hiện công việc sau:
      a.  In ra màn hình String đảo ngược của S
      b.  Đổi toàn bộ kí tự của S sang chữ Hoa
      c.  Đổi toàn bộ kí tự của S sang chữ thường
      d.  Đưa ra bảng tần số xuất hiện của các kí tự trong S
      e.  Trích ra chuỗi con của từ kí tự thứ n đến thứ m của S (n, m nhập từ bàn phím)

     */
    public static void daoNguocChuoi(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        System.out.println("Chuỗi đảo ngược của S là: " + stringBuilder.reverse());
        System.out.println("Đổi toàn bộ kí tự của S sang chữ Hoa: " + s.toUpperCase());
        System.out.println("Đổi toàn bộ kí tự của S sang chữ thường: " + s.toLowerCase());

    }

    public static void inBangTanSoXuatHien(String str) {
        // Sử dụng Map để lưu tần số xuất hiện của các kí tự
        Map<Character, Integer> tanSoMap = new HashMap<>();

        // Lặp qua từng kí tự trong chuỗi và cập nhật bảng tần số
        for (char ch : str.toCharArray()) {
            tanSoMap.put(ch, tanSoMap.getOrDefault(ch, 0) + 1);
        }

        // In bảng tần số xuất hiện
        System.out.println("Bảng tần số xuất hiện của các kí tự trong S:");
        for (Map.Entry<Character, Integer> entry : tanSoMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void trichChuoiCon() {
        String text = InputValidator.validateStringInput("Nhập vào một chuỗi: ");
        System.out.println("chuỗi ban đầu: " + text);
        Integer n = InputValidator.validateIntInput("Nhập vị trí bắt đầu (n):  ");
        Integer m = InputValidator.validateIntInput("Nhập vị trí kết thúc (m): ");
        String chuoiCon = catChuoi(text, n, m);
        System.out.println("Chuỗi con từ vị trí " + n + " đến " + m + ": " + chuoiCon);

    }
    public static String catChuoi(String str, int n, int m) {
        // Kiểm tra điều kiện hợp lệ
        if (n < 0 || m < n || m > str.length()) {
            throw new IllegalArgumentException("Vị trí bắt đầu hoặc kết thúc không hợp lệ.");
        }

        // Sử dụng phương thức substring để trích ra chuỗi con
        return str.substring(n, m + 1);
    }




}
