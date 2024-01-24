public class SumOfIntegers {
    public static void main(String[] args) {
        // Get user input for five integers
        int num1 = InputValidate.validateIntInput("Input first number: ");
        int num2 = InputValidate.validateIntInput("Input second number: ");
        int num3 = InputValidate.validateIntInput("Input third number: ");
        int num4 = InputValidate.validateIntInput("Input fourth number: ");
        int num5 = InputValidate.validateIntInput("Input fifth number: ");

        // Calculate the sum
        int sum = num1 + num2 + num3 + num4 + num5;

        // Print the result
        System.out.println("The sum is " + sum);
    }
}
