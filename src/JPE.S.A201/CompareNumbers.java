import java.util.Scanner;

public class CompareNumbers {
    public static void main(String[] args) {
        // Get user input for four integers
        Scanner scanner = new Scanner(System.in);
        int num1 = InputValidate.validateIntInput("Input first number: ");

        int num2 = InputValidate.validateIntInput("Input second number: ");

        int num3 = InputValidate.validateIntInput("Input third number: ");

        int num4 = InputValidate.validateIntInput("Input fourth number: ");

        // Compare the numbers and print the result
        if (num1 == num2 && num2 == num3 && num3 == num4) {
            System.out.println("Numbers are equal!");
        } else {
            System.out.println("Numbers are not equal!");
        }

        // Close the scanner
        scanner.close();
    }

}
