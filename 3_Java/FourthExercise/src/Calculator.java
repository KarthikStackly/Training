import java.util.Scanner;

public class Calculator {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Calculator ***");
        System.out.println("Enter 2 numbers: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        System.out.println("Choose an Operation from below : ");
        System.out.print("\n1. Addition (+)\n2.Subtraction (-)\n3.Multiplication (*)\n4.Division (/)\n====> ");
//        String operator = scan.next();
        char operator = scan.next().charAt(0);

        switch(operator) {
            case '+':
                System.out.printf("%d %s %d = %d", num1, operator, num2, num1+num2);
                break;
            case '-':
                System.out.printf("%d %s %d = %d", num1, operator, num2, num1-num2);
                break;
            case '*':
                System.out.printf("%d %s %d = %d", num1, operator, num2, num1*num2);
                break;
            case '/':
                System.out.printf("%d %s %d = %.2f", num1, operator, num2, (double) (num1/num2));
                break;
            default:
                System.out.println("Please enter the correct operator");
        }

        scan.close();
    }
}
