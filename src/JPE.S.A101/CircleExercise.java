import java.util.Scanner;

public class CircleExercise {
    public static void main(String[] args) {
        // Get user input for the radius
        Scanner scanner = new Scanner(System.in);
        double radius = InputValidate.validateDoubleInput("Enter the radius of the circle: ");

        // Calculate area and perimeter
        double area = calculateArea(radius);
        double perimeter = calculatePerimeter(radius);

        // Print the results
        System.out.println("Perimeter is = " + perimeter);
        System.out.println("Area is = " + area);

        // Close the scanner
        scanner.close();
    }

    public static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    public static double calculatePerimeter(double radius) {
        return 2 * Math.PI * radius;
    }
}