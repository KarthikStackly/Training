import java.util.Scanner;

public class ShapeOfYou {


    static double circleArea(double radius) {
        return Math.PI * radius * radius;
    }

    static double squareArea(double side) {
        return side * side;
    }

    static double triangleArea(double base, double height) {
        return 0.5 * base * height;
    }

    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Areas of different shapes ***");

        boolean keepGoing = true;

        do {
            System.out.print("\n0. Exit\n1. Circle\n2. Square\n3. Triangle\n=====> : ");
            int choice = scan.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.println("OK BYE!");
                    keepGoing = false;
                }
                case 1 -> {
                    System.out.print("Enter radius of the circle: ");
                    double radius = scan.nextDouble();
                    System.out.printf("Area of Circle: %.2f\n", circleArea(radius));
                }
                case 2 -> {
                    System.out.print("Enter side length of the square: ");
                    double side = scan.nextDouble();
                    System.out.printf("Area of Square: %.2f\n", squareArea(side));
                }
                case 3 -> {
                    System.out.print("Enter base of the triangle: ");
                    double base = scan.nextDouble();
                    System.out.print("Enter height of the triangle: ");
                    double height = scan.nextDouble();
                    System.out.printf("Area of Triangle: %.2f\n", triangleArea(base, height));
                }
                default -> System.out.println("Enter a valid choice");
            }

        } while (keepGoing);

        scan.close();
    }
}