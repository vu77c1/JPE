import java.util.Scanner;

public class Validator {
    private static final Scanner scanner = new Scanner(System.in);

    public static String validateCourseCode(String prompt) {
        String input = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (input.startsWith("FW") && input.matches("FW\\d{3}")) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Course code is valid.\u001B[0m");
            }
        } while (!isValid);

        return input;
    }

    public static String validateCourseName(String prompt) {
        String input = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Course code is valid.\u001B[0m");
            }
        } while (!isValid);

        return input;
    }

    public static double validateDuration(String prompt) {
        double input = 0.0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                input = Double.parseDouble(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31mError: Please enter a valid double.\u001B[0m");
            }
        } while (!isValid);

        return input;
    }

    public static String validateStatus(String prompt) {
        String input = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("active") || input.equals("in-active")) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Status is valid.\u001B[0m");
            }
        } while (!isValid);

        return input;
    }
    public static String validateFlag(String prompt) {
        String input = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            input = scanner.nextLine().trim().toLowerCase();

            if (input.equals("optional") || input.equals("mandatory")||input.equals("n/a")) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Flag is valid.\u001B[0m");
            }
        } while (!isValid);

        return input;
    }
    public static Integer validateMenu(String prompt) {
        int input = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31mError: Please enter a valid integer.\u001B[0m");
            }
        } while (!isValid);

        return input;
    }
    public static String validateStringInput(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim();

            if (!userInput.isEmpty()) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Input cannot be empty.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }

}
