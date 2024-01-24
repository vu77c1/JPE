import java.util.*;

public class PersonManage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Menu:");
            System.out.println("1. Input data from the keyboard");
            System.out.println("2. Update student");
            System.out.println("3. Display teacher with salary > $1000");
            System.out.println("4. Report: Display students with final mark >= 6");
            System.out.println("0. Exit");
            choice = PersonManageValidator.validateIntInput("Enter your choice:");
            switch (choice) {
                case 1:
                    displayAllPersons(RandomListPerson());
                    break;
                case 2:
                    updateStudentInfo();
                    break;
                case 3:
                    getTeacherBySalary();
                    break;
                case 4:
                    reportStudentByFinalMark();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);

        scanner.close();


    }

    private static void inputCommonDetails(Person person) {
        person.setFullName(PersonManageValidator.validateStringInput("Enter Full Name: "));
        person.setGender(PersonManageValidator.validateGenderInput("Enter Gender (male or female): "));
        person.setBirthDate(PersonManageValidator.validateDateInput("Enter birth day (format: dd/mm/yyyy): "));
        person.setEmail(PersonManageValidator.validateEmailInput("Enter Email: "));
        person.setPhone(PersonManageValidator.validatePhoneNumber("Enter Phone: "));
    }

    private static Student createStudent() {
        Student student = new Student();
        inputCommonDetails(student);
        student.inputCommonDetails(student);
        student.setStudentId(PersonManageValidator.validateStringInput("Enter Student ID: "));
        student.setTheory(PersonManageValidator.validatePracticeAndTheoryInput("Enter Theory: "));
        student.setPractice(PersonManageValidator.validatePracticeAndTheoryInput("Enter Practice: "));
        return student;
    }

    // Helper method to create a Teacher
    private static Teacher createTeacher() {
        Teacher teacher = new Teacher();
        teacher.inputCommonDetails(teacher);
        teacher.setSubsidy(PersonManageValidator.validateSalaryAndSubsidyInput("Enter Subsidy: "));
        teacher.setBasicSalary(PersonManageValidator.validateSalaryAndSubsidyInput("Enter Basic salary: "));
        return teacher;
    }

    public static List<Person> listPersonInput() {
        List<Person> personList = new ArrayList<>();

        // Nhập danh sách giáo viên
        for (int i = 0; i < 2; i++) {
            System.out.println("Nhập thông tin cho Giáo viên " + (i + 1));
            Teacher teacher = createTeacher();
            personList.add(teacher);
        }

        // Nhập danh sách học sinh
        for (int i = 0; i < 2; i++) {
            System.out.println("Nhập thông tin cho Học sinh " + (i + 1));
//            Students student = createStudent();
//            personList.add(student);
        }
        return personList;

    }

    private static List<Person> RandomListPerson() {
        List<Person> personList = new ArrayList<>();
        // Tạo dữ liệu mẫu cho 5 giáo viên
        personList.add(new Teacher("Teacher 1", "Male", "1234567891", "teacher1@example.com", new Date(), 10000000.0, 2000000.0));
        personList.add(new Teacher("Teacher 2", "Female", "1234567892", "teacher2@example.com", new Date(), 11000000.0, 2500000.0));
        personList.add(new Teacher("Teacher 3", "Male", "1234567893", "teacher3@example.com", new Date(), 12000000.0, 2200000.0));
        personList.add(new Teacher("Teacher 4", "Female", "1234567894", "teacher4@example.com", new Date(), 9500000.0, 1800000.0));
        personList.add(new Teacher("Teacher 5", "Male", "1234567895", "teacher5@example.com", new Date(), 10500000.0, 2300000.0));

        // Tạo dữ liệu mẫu cho 5 học sinh
        personList.add(new Student("Student 1", "Female", "9876543211", "student1@example.com", new Date(), "S1", 8.5, 7.5));
        personList.add(new Student("Student 2", "Female", "9876543212", "student2@example.com", new Date(), "S2", 9.5, 5));
        personList.add(new Student("Student 3", "Female", "9876543213", "student3@example.com", new Date(), "S3", 7.5, 8.5));
        personList.add(new Student("Student 4", "Female", "9876543214", "student4@example.com", new Date(), "S4", 5, 9.5));
        personList.add(new Student("Student 5", "Female", "9876543215", "student5@example.com", new Date(), "S5", 4, 6.0));
        return personList;

    }

    private static void displayAllPersons(List<Person> personList) {
        System.out.println("Danh sách Person:");
        for (Person person : personList) {
            System.out.println(person);
        }
    }

    //c.	Display teacher: displays information about teachers, who has a salary higher than 1000$.
    private static void getTeacherBySalary() {
        StringBuilder formattedOutput = new StringBuilder();

        System.out.println("Danh sách Person:");
        formattedOutput.append(String.format("%-15s %-10s %-15s %-25s %-15s %-15s %-15s %-15s\n",
                "Full Name", "Gender", "Phone", "Email", "Birth Date", "Basic Salary", "Subsidy", "Salary"));
        System.out.println(formattedOutput);
        {
            for (Person p : RandomListPerson()) {
                if (p instanceof Teacher && ((Teacher) p).calculateSalary() > 12000000) {
                    System.out.println(p);
                }
            }

        }
    }
    //d.	Report: display all students and their final mark, who qualify to pass the course (final mark >= 6).

    private static void reportStudentByFinalMark() {
        StringBuilder formattedOutput = new StringBuilder();

        System.out.println("Danh sách Person:");
        formattedOutput.append(String.format("%-15s %-10s %-15s %-25s %-15s %-10s %-10s %-15s %-15s\n",
                "Full Name", "Gender", "Phone", "Email", "Birth Date", "Student ID", "Theory", "Practice", "Final Mark"));
        System.out.println(formattedOutput);
        for (Person person : RandomListPerson()) {
            if (person instanceof Student && ((Student) person).calculateFinalMark() > 7) {
                System.out.println(person);
            }
        }
    }

    public static void updateStudentInfoByColumn(Student studentToUpdate) {
        System.out.println("Choose a column to update:");
        System.out.println("1. Full Name");
        System.out.println("2. Gender");
        System.out.println("3. Phone");
        System.out.println("4. Email");
        System.out.println("5. Birth Date");
        System.out.println("6. Student ID");
        System.out.println("7. Theory Score");
        System.out.println("8. Practice Score");
        System.out.println("0. Exit");

        int choice;
        do {
            choice = PersonManageValidator.validateIntInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    studentToUpdate.setFullName(PersonManageValidator.validateStringInput("Enter new Full Name: "));
                    System.out.println("Updated List of Persons:");
                    break;
                case 2:
                    studentToUpdate.setGender(PersonManageValidator.validateGenderInput("Enter new Gender: "));
                    break;
                case 3:
                    studentToUpdate.setPhone(PersonManageValidator.validatePhoneNumber("Enter new Phone: "));
                    break;
                case 4:
                    studentToUpdate.setEmail(PersonManageValidator.validateEmailInput("Enter new Email: "));
                    break;
                case 5:
                    studentToUpdate.setBirthDate(PersonManageValidator.validateDateInput("Enter new Birth Date (dd/MM/yyyy): "));
                    break;
                case 6:
                    studentToUpdate.setStudentId(PersonManageValidator.validateStringInput("Enter new Student ID: "));
                    break;
                case 7:
                    studentToUpdate.setTheory(PersonManageValidator.validatePracticeAndTheoryInput("Enter new Theory Score: "));
                    break;
                case 8:
                    studentToUpdate.setPractice(PersonManageValidator.validatePracticeAndTheoryInput("Enter new Practice Score: "));
                    break;
                case 0:
                    System.out.println("Exiting update menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }

        } while (choice != 0);
    }

    public static void updateStudentInfo() {
        List<Person> personList = RandomListPerson();

        String studentIdToUpdate = PersonManageValidator.validateStringInput("Enter the Student ID to update: ");

        for (Person persons : personList) {
            if (persons instanceof Student) {
                Student currentStudent = (Student) persons;
                if (currentStudent.getStudentId().equals(studentIdToUpdate)) {
                    System.out.println("Updating information for student with ID " + studentIdToUpdate + ":");
                    updateStudentInfoByColumn(currentStudent);
                    System.out.println("Student information updated successfully.");
                }
            }
        }
        System.out.println("Updated List of Persons:");
        for (Person person : personList) {
            System.out.println(person);
        }


        System.out.println("Student with ID " + studentIdToUpdate + " not found.");
    }

}