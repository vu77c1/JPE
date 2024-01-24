import java.util.*;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> myMap = new HashMap<>();

        // Thêm cặp khóa-giá trị vào bản đồ
        myMap.put("One", 1);
        myMap.put("Two", 3);
        myMap.put("Three", 2);
        // Tạo một đối tượng HashMap
        // Sorting by values using a List and Collections.sort
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(myMap.entrySet());
        Collections.sort(entryList, Comparator.comparing(Map.Entry::getValue));

        // Displaying sorted list by values
        System.out.println("Sorted by Values:");
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }


        // Hiển thị nội dung của bản đồ
        System.out.println("Initial Map: " + myMap);

        // Sử dụng một số phương thức của Map
        System.out.println("Is the map empty? " + myMap.isEmpty());
        System.out.println("Size of the map: " + myMap.size());

        // Lấy tập hợp các khóa
        Set<String> keys = myMap.keySet();
        System.out.println("Keys in the map: " + keys);

        // Xóa một mục từ bản đồ
        myMap.remove("Two");
        System.out.println("Map after removing 'Two': " + myMap);

        // Kiểm tra xem một khóa có tồn tại không
        System.out.println("Does 'Three' exist in the map? " + myMap.containsKey("Three"));

        // Lấy giá trị của một khóa
        int value = myMap.get("One");
        System.out.println("Value associated with 'One': " + value);

        // Xóa tất cả các mục từ bản đồ
        myMap.clear();
        System.out.println("Map after clearing: " + myMap);




        // Tạo một đối tượng HashMap
        Map<String, Integer> destinationMap = new HashMap<>();
        destinationMap.put("A", 1);
        destinationMap.put("B", 2);

        // Tạo một bản đồ khác để sao chép vào bản đồ đầu tiên
        Map<String, Integer> sourceMap = new HashMap<>();
        sourceMap.put("C", 3);
        sourceMap.put("D", 4);
        sourceMap.putIfAbsent("D",2);

        // Hiển thị nội dung của bản đồ đích trước khi sao chép
        System.out.println("Destination Map before putAll: " + destinationMap);

        // Sử dụng phương thức putAll để sao chép ánh xạ từ bản đồ nguồn vào bản đồ đích
        destinationMap.putAll(sourceMap);

        // Hiển thị nội dung của bản đồ đích sau khi sao chép
        System.out.println("Destination Map after putAll: " + destinationMap);

        // Kiểm tra xem bản đồ có chứa giá trị cụ thể không
        boolean containsValue = myMap.containsValue(2);
        System.out.println("Does the map contain the value 2? " + containsValue);

        // Kiểm tra xem bản đồ có chứa khóa cụ thể không
        boolean containsKey = myMap.containsKey("Four");
        System.out.println("Does the map contain the key 'Four'? " + containsKey);

        // Lấy giá trị của một khóa
        Integer valuel = myMap.get("Two");
        System.out.println("Value associated with 'Two': " + valuel);

        // Thay thế giá trị của một khóa
        Integer replacedValue = myMap.replace("Three", 33);
        System.out.println("Replaced value associated with 'Three': " + replacedValue);
        System.out.println("Updated Map: " + myMap);

        // Thay thế giá trị của một khóa chỉ khi giá trị cũ khớp
        boolean replaceResult = myMap.replace("Three", 33, 333);
        System.out.println("Was the value replaced? " + replaceResult);
        System.out.println("Map after conditional replace: " + myMap);

        // Hiển thị tất cả các giá trị trong bản đồ
        Collection<Integer> values = myMap.values();
        System.out.println("Values in the map: " + values);

        // Hiển thị kích thước của bản đồ
        int size = myMap.size();
        System.out.println("Size of the map: " + size);
    }
}
