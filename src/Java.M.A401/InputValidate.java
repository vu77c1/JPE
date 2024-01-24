

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputValidate {
    private static Scanner scanner = new Scanner(System.in);
    public static Date validateDateInput(String prompt) {
        Date date = null;
        boolean isValid = false;

        do {
            try {
                System.out.print(prompt);
                String dateString = scanner.nextLine().trim();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateFormat.setLenient(false);
                date = dateFormat.parse(dateString);
                isValid = true;
            } catch (ParseException ex) {
                System.out.println("Error: Please enter a valid date in the format 'yyyy-MM-dd'.");
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
                System.out.println("Error: Input cannot be empty.");
            }
        } while (!isValid);

        return userInput;
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
                System.out.println("Error: Please enter a valid double.");
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
                System.out.println("Error: Please enter a valid integer.");
            }
        } while (!isValid);

        return userInput;
    }
    public static void closeScanner() {
        scanner.close();
    }

}