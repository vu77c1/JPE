package JPL.L.A202.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
    private static Scanner scanner = new Scanner(System.in);

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


    //ham kiểm tra kí tự đặc biệt
    private static boolean containsSpecialCharacter(String str) {
        // Sử dụng biểu thức chính quy để kiểm tra xem chuỗi có chứa ký tự đặc biệt không
        return str.matches(".*[!@#$%^&*()_+{}|\"<>?].*");
    }

    public static double validateDoubleInput(String prompt) {
        double userInput = 0.0;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                userInput = Double.parseDouble(scanner.nextLine());
                isValid = true;
            } catch (NumberFormatException ex) {
                System.out.println("\u001B[31mError: Please enter a valid double.\u001B[0m");
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
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Define a regex pattern for a phone number with a minimum of 7 positive integers
        String regex = "\\d{7,}";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(phoneNumber);

        // Check if the phone number matches the pattern
        return matcher.matches();
    }
    public static String validatePhoneNumber(String prompt) {
        String userInput;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine();

            if (isValidPhoneNumber(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Please enter a valid phone number with at least 7 digits.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }

    private static boolean isValidDateFormat(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false); // This will cause the SimpleDateFormat to be strict in parsing

        try {
            Date parsedDate = dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static String validateBirthDate(String prompt) {
        String userInput;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine();

            if (isValidDateFormat(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Please enter a valid date in the format dd/MM/yyyy.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }

    public static boolean isValidEmailFormat(String email) {
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();
    }

    public static String validateEmail(String prompt) {
        String userInput;
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine();

            if (isValidEmailFormat(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Please enter a valid email address.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }


}
