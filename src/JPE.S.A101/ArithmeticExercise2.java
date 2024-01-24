import java.util.Scanner;

public class ArithmeticExercise2 {
    public static void main(String[] args) {
        // Get user input
        Scanner scanner = new Scanner(System.in);

        double firstNumber=   InputValidate.validateDoubleInput("Input first number: ");
        double secondNumber=   InputValidate.validateDoubleInput("Input second number: ");


        // Perform arithmetic operations
        double sum = firstNumber + secondNumber;
        double difference = firstNumber - secondNumber;
        double product = firstNumber * secondNumber;
        double quotient = firstNumber / secondNumber;
        double remainder = firstNumber % secondNumber;

        // Print the results
        System.out.println(firstNumber + " + " + secondNumber + " = " + sum);
        System.out.println(firstNumber + " - " + secondNumber + " = " + difference);
        System.out.println(firstNumber + " x " + secondNumber + " = " + product);
        System.out.println(firstNumber + " / " + secondNumber + " = " + quotient);
        System.out.println(firstNumber + " % " + secondNumber + " = " + remainder);

        // Close the scanner
        scanner.close();
    }
}
