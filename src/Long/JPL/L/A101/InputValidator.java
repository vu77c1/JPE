package JPL.L.A101;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputValidator {
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


}
