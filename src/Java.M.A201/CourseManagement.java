import java.util.*;

public class CourseManagement {
    static Scanner scanner = new Scanner(System.in);
    private static Map<Integer, Course> list = new HashMap<>();

    public static void main(String[] args) {
        
        while (true) {
            displayMenu();
            int choice = Validator.validateMenu("Enter your choice (1-3, 0 to exit):");
            switch (choice) {
                case 1:
                    addCourse();
                    printListCourse();
                    break;
                case 2:
                    System.out.println("1. search by code");
                    System.out.println("2. search by name");
                    int c=Validator.validateMenu("Enter your choice (1-2, 0 to exit):");
                    switch (c) {
                        case 1:
                            String code=Validator.validateStringInput("Enter code: ");
                            find("code", code);
                            break;
                        case 2:
                            String input=Validator.validateStringInput("Enter name: ");
                            find("name", input);
                            break;
                        case 0:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Invalid choice. Please enter a valid option.");
                    }

                    break;
                case 3:
                    displayFlagIsMandatory();
                    break;
                case 0:
                    System.out.println("Exiting program. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

    }

    private static void displayMenu() {
        System.out.println("=== Menu ===");
        System.out.println("1. Create an array of 10 courses");
        System.out.println("2. Search");
        System.out.println("3. Display all courses that flag is “mandatory”");
        System.out.println("0. Exit");
    }

    public static void addCourse() {

        System.out.println("Create an array of 10 courses ");
        for (int i = 0; i < 2; i++) {
            Course course = new Course();
            System.out.println("Add courses " + (i + 1));
            course.input();
            list.put(i + 1, course);
        }
    }

    public static void printListCourse() {
        System.out.println("List of Courses:");
        System.out.println("No" + "\t" + "courseCode" + "\t" + "courseName" + "\t" + "duration" + "\t" + "status" + "\t" + "flag");
        for (Map.Entry<Integer, Course> entry : list.entrySet()) {
            System.out.println(entry.getKey() + "\t" + entry.getValue().toString());
        }
    }

    //c.	Display all courses that flag is “mandatory”.
    public static void displayFlagIsMandatory() {

        for (Map.Entry<Integer, Course> entry : list.entrySet()) {
            if (entry.getValue().getFlag().equals("mandatory")) {
                System.out.println(entry.getKey() + "\t" + entry.getValue().toString());

            }
        }
    }

    public static void find(String type, Object data) {
        System.out.println("Searching for courses by " + type + ": " + data);

        switch (type.toLowerCase()) {
            case "code":
                findCoursesByCode(data.toString());
                break;
            case "name":
                findCoursesByName(data.toString());
                break;
            // Add more cases for other attributes as needed
            default:
                System.out.println("Invalid attribute type for search.");
        }
    }

    private static void findCoursesByCode(String code) {
        for (Course course : list.values()) {
            if (course.getCourseCode().equalsIgnoreCase(code)) {
                System.out.println("Course found:");
                System.out.println(course);
            }
        }
    }

    private static void findCoursesByName(String name) {
        for (Course course : list.values()) {
            if (course.getCourseName().equalsIgnoreCase(name)) {
                System.out.println("Course found:");
                System.out.println(course);
            }
        }
        System.out.println("Course not found.");
    }


}
