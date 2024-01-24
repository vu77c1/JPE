import java.util.Scanner;

public class Arithmetic {
    public static void main(String[] args) {
        displayMenu();
    }
    public static void displayMenu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Arithmetic Operations Menu:");
            System.out.println("1. Calculate -5 + 8 * 6");
            System.out.println("2. Calculate (55 + 9) % 9");
            System.out.println("3. Calculate 20 + -3 * 5 / 8");
            System.out.println("4. Calculate 5 + 15 / 3 * 2 - 8 % 3");
            System.out.println("0. Exit");
            int choice = InputValidate.validateIntInput("Enter your choice (0-4): ");

            switch (choice) {
                case 1:
                    calculateExpression1();
                    break;
                case 2:
                    calculateExpression2();
                    break;
                case 3:
                    calculateExpression3();
                    break;
                case 4:
                    calculateExpression4();
                    break;
                case 0:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 0 and 4.");
            }
        }
    }

    public static void calculateExpression1() {
        int result = -5 + 8 * 6;
        System.out.println("Result: " + result);
    }

    public static void calculateExpression2() {
        int result = (55 + 9) % 9;
        System.out.println("Result: " + result);
    }

    public static void calculateExpression3() {
        int result = 20 + -3 * 5 / 8;
        System.out.println("Result: " + result);
    }

    public static void calculateExpression4() {
        int result = 5 + 15 / 3 * 2 - 8 % 3;
        System.out.println("Result: " + result);
    }
}

