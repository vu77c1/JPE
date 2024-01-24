import java.util.Scanner;

public class RectangleExercise {
    public static void main(String[] args) {
        // Get user input for the width and height
        Scanner scanner = new Scanner(System.in);
        double width =InputValidate.validateDoubleInput("Enter the width of the rectangle: ");
        double height = InputValidate.validateDoubleInput("Enter the height of the rectangle: ");
        double area = calculateArea(width, height);
        double perimeter = calculatePerimeter(width, height);
        System.out.println("Area is " + width + " * " + height + " = " + area);
        System.out.println("Perimeter is 2 * (" + width + " + " + height + ") = " + perimeter);
        scanner.close();
    }

    public static double calculateArea(double width, double height) {
        return width * height;
    }

    public static double calculatePerimeter(double width, double height) {
        return 2 * (width + height);
    }
}