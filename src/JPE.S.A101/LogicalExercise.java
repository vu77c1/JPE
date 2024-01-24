import java.util.Scanner;

public class LogicalExercise {
    public static void main(String[] args) {
        // Get user input for the first and second integers
        Scanner scanner = new Scanner(System.in);
        int firstInteger =  InputValidate.validateIntInput("Input first integer: ");
        int secondInteger = InputValidate.validateIntInput("Input second integer: ");

        // Compare the numbers and print the results
        System.out.println(firstInteger + " != " + secondInteger + " : " + (firstInteger != secondInteger));
        System.out.println(firstInteger + " < " + secondInteger + " : " + (firstInteger < secondInteger));
        System.out.println(firstInteger + " <= " + secondInteger + " : " + (firstInteger <= secondInteger));

        // Close the scanner
        scanner.close();
    }
}
