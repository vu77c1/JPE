public class CylinderComputation {
    public static void main(String[] args) {
        // Given values for radius and height
        /*double radius = 7.5;
        double height = 10.5;*/
        double radius = InputValidate.validateDoubleInput("Enter the radius of the cylinder: ");

        // Prompt the user to enter the height
        double height = InputValidate.validateDoubleInput("Enter the height of the cylinder: ");
        // Calculate surface area, base area, and volume
        double surfaceArea = 2 * Math.PI * radius * (radius + height);
        double baseArea = Math.PI * radius * radius;
        double volume = Math.PI * radius * radius * height;

        // Print the results
        System.out.println("Surface area = " + surfaceArea);
        System.out.println("Base area = " + baseArea);
        System.out.println("Volume = " + volume);
    }
}
