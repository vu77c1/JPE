import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerValidate {
    private static Scanner scanner = new Scanner(System.in);

    public static boolean isValidOrderNumber(String orderNumber) {
        // Regex pattern for a numeric string with exactly 10 characters
        String regex = "\\d{10}";
        // Compile the pattern
        Pattern pattern = Pattern.compile(regex);
        // Create a Matcher object
        Matcher matcher = pattern.matcher(orderNumber);

        // Check if the order number matches the pattern
        return matcher.matches();
    }

    public static String validateOrderNumberInput(String prompt) {
        String userInput = "";
        boolean isValid = false;

        do {
            System.out.print(prompt);
            userInput = scanner.nextLine().trim().toLowerCase();
            if (isValidOrderNumber(userInput)) {
                isValid = true;
            } else {
                System.out.println("\u001B[31mError: Order number is valid.\u001B[0m");
            }
        } while (!isValid);

        return userInput;
    }
}
