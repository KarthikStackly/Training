import java.util.Scanner;

public class MultiplicationTable {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.print("*** Multiplication Table ***\nEnter a number: ");
        int num = scan.nextInt();
        for(int i = 1; i <= 10; i++) {
            System.out.printf("%d x %d = %d%n", num, i, num*i);
        }

        scan.close();
    }
}
