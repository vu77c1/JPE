import java.util.*;

public class TT {
    public static void main(String[] args) {
        List<SV> studentsList = new ArrayList<>();
        studentsList.add(new SV("Huynh Tuan An Tran Huy ", 21, "Quy Nhon"));
        studentsList.add(new SV("Pham Ngoc Huy Quy", 22, "Hoai Nhon"));
        studentsList.add(new SV("Hoang Huy Dung", 23, "An Lao"));
        studentsList.add(new SV("Nguyen Van Lam", 24, "Hoai An"));
        studentsList.add(new SV("Nguyen Hoang Nam", 25, "Quy Nhon"));
        studentsList.add(new SV("Nguyen Xuan Phuong ", 19, "Phu Cat"));
        studentsList.add(new SV("Nguyen Trong Nghia", 27, "DiaChi7"));
        studentsList.add(new SV("Hoang Nam Tien", 28, "An Lao"));
        studentsList.add(new SV("Phan Thi Dinh", 29, "Tay Son"));
        studentsList.add(new SV("Le Nguyen Nguyen", 30, "An Nhon"));
        System.out.println();
        System.out.println();
        System.out.println();

        // In thông tin của các đối tượng SV trong danh sách
        printListSV(studentsList);
        System.out.println("Tất cả các học sinh có tên bắt đầu bằng chữ H");
        printListSV(getStudentByName(studentsList));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Tất cả các học sinh có tên bắt đầu bằng chữ H cach 2");
        printListSV(getStudentByName2(studentsList));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Tất cả các học sinh có tên bắt đầu bằng chữ H cach 3");
        printListSV(getStudentByName3(studentsList));
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Tất cả các học sinh co ho Nguyen va lon hon 20 tuoi");
        printListSV(getStudentByHo(studentsList));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Tất cả các học sinh co ho Nguyen va lon hon 20 tuoi cach 2");
        printListSV(getStudentByHo2(studentsList));
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Tất cả các học sinh co ho Nguyen va lon hon 20 tuoi cach 3");
        printListSV(getStudentByHo3(studentsList));

    }

    private static void printListSV(List<SV> studentsList) {
        studentsList.forEach(student -> System.out.println("Name: " + student.getName() +
                ", Age: " + student.getAge() +
                ", Address: " + student.getAddress()));
    }

    public static   List<SV> getStudentByName(List<SV> studentsList) {

        List<SV> temp = new ArrayList<>();
        for (SV sv : studentsList) {

            String[] arr = sv.getName().split(" ");
            if ((arr[arr.length-1]).charAt(0) == 'H') {
                temp.add(sv);
            }
        }

        return temp;
    }
    public static   List<SV> getStudentByName2(List<SV> studentsList) {
        List<SV> temp = new ArrayList<>();
        for (SV sv : studentsList) {

            // Tìm vị trí bắt đầu của chuỗi "Huy" trong tên
            int startIndex = sv.getName().trim().lastIndexOf(" ");
            if (startIndex != -1 && startIndex + 1 < sv.getName().length() &&sv.getName().substring(startIndex+1,startIndex+2).equals("H")) {
                temp.add(sv);
            }
        }

        return temp;
    }
    public static   List<SV> getStudentByName3(List<SV> studentsList) {
        List<SV> temp = new ArrayList<>();
        for (SV sv : studentsList) {
            String[] arr = sv.getName().split(" ");
            if ((arr[arr.length-1]).substring(0,1).equals("H")) {
                temp.add(sv);
            }
        }

        return temp;
    }
    public static   List<SV> getStudentByHo(List<SV> studentsList) {
        List<SV> temp = new ArrayList<>();
        for (SV sv : studentsList) {
            int startIndex = sv.getName().indexOf("");
            if (startIndex != -1  &&sv.getName().substring(startIndex,startIndex+6).equals("Nguyen")) {
                temp.add(sv);
                break;
            }
        }

        return temp;
    }
    public static   List<SV> getStudentByHo2(List<SV> studentsList) {
        List<SV> temp = new ArrayList<>();
        for (SV sv : studentsList) {
            if (sv.getName().trim().substring(0,6).equals("Nguyen") && sv.getAge()>20) {
                temp.add(sv);
                break;
            }
        }

        return temp;
    }
    public static   List<SV> getStudentByHo3(List<SV> studentsList) {
        List<SV> temp = new ArrayList<>();
        for (SV sv : studentsList) {
            String[] arr = sv.getName().split(" ");
            if (arr[0].equals("Nguyen") && sv.getAge()>20) {
                temp.add(sv);
                break;
            }
        }

        return temp;
    }
    //in ra ho dem cua ten dai nhat


}
