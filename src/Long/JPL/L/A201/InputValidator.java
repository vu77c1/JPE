package JPL.L.A201;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InputValidator {
    private static Scanner scanner = new Scanner(System.in);
    private static final String FIXED_WING_REGEX = "FW\\d{5}";
    private static final String HELICOPTER_REGEX = "RW\\d{5}";
    private static final String AIRPORT_REGEX = "AP\\d{5}";

    public static boolean isValidFixedWingId(String id) {
        return Pattern.matches(FIXED_WING_REGEX, id);
    }

    public static boolean isValidHelicopterId(String id) {
        return Pattern.matches(HELICOPTER_REGEX, id);
    }

    public static boolean isValidAirportId(String id) {
        return Pattern.matches(AIRPORT_REGEX, id);
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
    public static String validateHelicopterId(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim();

            if (!userInput.isEmpty()&&isValidHelicopterId(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Input cannot be empty.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }
    public static String validateFixedWingId(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim();

            if (!userInput.isEmpty()&&isValidFixedWingId(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Input cannot be empty.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }
    public static String validateAirportId(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim();

            if (!userInput.isEmpty()&&isValidAirportId(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Input cannot be empty.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
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
    public static String validateIsbn(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String isbn;
        boolean validIsbn;

        do {
            System.out.print(prompt);
            isbn = scanner.nextLine();
            validIsbn = isValidIsbn(isbn);

            if (!validIsbn) {
                System.out.println("Error: Please enter a valid ISBN.");
            }

        } while (!validIsbn);

        return isbn;
    }

    private static boolean isValidIsbn(String isbn) {
        // ISBN nên có từ 10-17 chữ số với dấu gạch ngang
        return isbn.matches("^\\d{3}-\\d{1,5}-\\d{1,7}-\\d{1,7}(?:-\\d)?$");

    }
    private static boolean isValidModel(String model) {
        // Use regex to check if the model has at most 40 characters
        return Pattern.matches("^.{0,40}$", model);
    }
    public static String validateModel(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String isbn;
        boolean validIsbn;

        do {
            System.out.print(prompt);
            isbn = scanner.nextLine();
            validIsbn = isValidModel(isbn);

            if (!validIsbn) {
                System.out.println("Error: Please enter a valid model.");
            }

        } while (!validIsbn);

        return isbn;
    }
    public static String validatePlaneType(String prompt) {
        Scanner scanner = new Scanner(System.in);
        String isbn;
        boolean validIsbn;

        do {
            System.out.print(prompt);
            isbn = scanner.nextLine();
            validIsbn = isValidPlaneType(isbn);

            if (!validIsbn) {
                System.out.println("Error: Please enter a valid model.");
            }

        } while (!validIsbn);

        return isbn;
    }
    private static boolean isValidPlaneType(String type) {
        // Define the regex pattern for valid plane types
        String regexPattern = "CAG|LGR|PRV";
        return Pattern.matches(regexPattern, type);
    }


}
