import java.util.HashSet;
import java.util.Iterator;
import java.util.Spliterator;

public class SET {
    public static void main(String[] args) {
        // Tạo một HashSet
        HashSet<String> fruitSet = new HashSet<>();


        // Thêm phần tử vào HashSet
        fruitSet.add("Apple");
        fruitSet.add("Banana");
        fruitSet.add("Orange");
        //Nếu phần tử thêm vào giống nhau
        System.out.println(fruitSet.add("Orange"));
        // Hiển thị kích thước của HashSet
        System.out.println("Size of HashSet: " + fruitSet.size());

        // Kiểm tra xem có phải HashSet rỗng hay không
        System.out.println("Is HashSet empty? " + fruitSet.isEmpty());

        // Kiểm tra xem HashSet có chứa một phần tử cụ thể hay không
        System.out.println("Does HashSet contain 'Apple'? " + fruitSet.contains("Apple"));

        // Sử dụng Iterator để duyệt qua các phần tử của HashSet
        Iterator<String> iterator = fruitSet.iterator();
        System.out.print("HashSet elements: ");
        while (iterator.hasNext()) {
            String fruit = iterator.next();
            System.out.print(fruit + " ");
        }
        System.out.println();
        // Lấy Spliterator từ danh sách
        Spliterator<String> spliterator = fruitSet.spliterator();

        // Duyệt qua các phần tử sử dụng Spliterator
        System.out.println("fruitSet elements:");
        spliterator.forEachRemaining(element -> System.out.println(element));

        // Xóa một phần tử từ HashSet
        boolean removed = fruitSet.remove("Banana");
        System.out.println("Is 'Banana' removed? " + removed);

        // Hiển thị lại kích thước của HashSet sau khi xóa
        System.out.println("Size of HashSet after removal: " + fruitSet.size());

        // Xóa tất cả các phần tử từ HashSet
        fruitSet.clear();
        System.out.println("Size of HashSet after clearing: " + fruitSet.size());
    }

}
