import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonManageValidator {
    static Scanner scanner = new Scanner(System.in);

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

    public static String validateGenderInput(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim().toLowerCase();
            if (userInput.equals("male") || userInput.equals("female")) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Gender is valid.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }
    public static Date validateDateInput(String prompt) {
        Date date = null;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                String dateString = scanner.nextLine().trim();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                dateFormat.setLenient(false);
                date = dateFormat.parse(dateString);
                isValid = true;
            } catch (ParseException ex) {
                System.out.println("\u001B[31mError: Please enter a valid date in the format 'dd/MM/yyyy'.\u001B[0m");
            }
        } while (!isValid);

        return date;
    }
    public static String validateEmailInput(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim().toLowerCase();
            if (isValidEmail(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Email is valid.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }
    private static boolean isValidEmail(String email) {
        // Regular expression for a simple email validation
        String emailRegex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static String validatePhoneNumber(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim();

            if (isValidPhoneNumber(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Invalid Vietnamese phone number format. Please enter a valid number.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        // Regular expression for a Vietnamese phone number validation
        String phoneRegex = "^(0[1-9][0-9]{8})$";

        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }
    public static Double validatePracticeAndTheoryInput(String prompt) {
        double userInput = 0.0;
        boolean isValid = false;
        do {

            try {
                System.out.print(prompt);
                userInput = Double.parseDouble(scanner.nextLine());
                if (userInput>=0&&userInput<=10) {
                    isValid = true;
                } else {
                    System.out.println("\u001B[31mError: Input is valid.\u001B[0m");
                }

            }
            catch (NumberFormatException exception)
            {
                System.out.println("\u001B[31mError: Input is valid.\u001B[0m");

            }
        } while (!isValid);

        return userInput;
    }
    public static Double validateSalaryAndSubsidyInput(String prompt) {
        double userInput = 0.0;
        boolean isValid = false;
        do {
            try {
                System.out.print(prompt);
                userInput = Double.parseDouble(scanner.nextLine());
                if (userInput>=0) {
                    isValid = true;
                } else {
                    System.out.println("\u001B[31mError: Input is valid.\u001B[0m");
                }

            }
            catch (NumberFormatException exception)
            {
                System.out.println("\u001B[31mError: Input is valid.\u001B[0m");

            }
        } while (!isValid);

        return userInput;
    }
    public static int validateIntInput(String prompt) {
        int userInput = 0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                userInput = Integer.parseInt(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31mError: Please enter a valid integer.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }
}
