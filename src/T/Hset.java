import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Hset {
    public static void main(String[] args) {
        // Tạo một Set sử dụng HashSet
        Set<String> fruitSet = new HashSet<>();

        // Thêm phần tử vào Set
        fruitSet.add("Apple");
        fruitSet.add("Banana");
        fruitSet.add("Orange");

        // Hiển thị kích thước của Set
        System.out.println("Size of Set: " + fruitSet.size());

        // Kiểm tra xem Set có rỗng hay không
        System.out.println("Is Set empty? " + fruitSet.isEmpty());

        // Kiểm tra xem Set có chứa một phần tử cụ thể hay không
        System.out.println("Does Set contain 'Apple'? " + fruitSet.contains("Apple"));

        // Sử dụng Iterator để duyệt qua các phần tử của Set
        Iterator<String> iterator = fruitSet.iterator();
        System.out.print("Set elements: ");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.print(fruit + " ");
        }
        System.out.println();

        // Xóa một phần tử từ Set
        boolean removed = fruitSet.remove("Banana");
        System.out.println("Is 'Banana' removed? " + removed);

        // Hiển thị lại kích thước của Set sau khi xóa
        System.out.println("Size of Set after removal: " + fruitSet.size());

        // Xóa tất cả các phần tử từ Set
        fruitSet.clear();
        System.out.println("Size of Set after clearing: " + fruitSet.size());
    }
}

