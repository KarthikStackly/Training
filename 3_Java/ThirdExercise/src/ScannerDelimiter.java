import java.util.Scanner;

public class ScannerDelimiter {

    static void main() {
        Scanner scan = new Scanner(System.in);

        System.out.println("*** Scanner Delimiter ***");
        System.out.print("Input 3 of your friends' names separated by a comma: ");

//      String names = scan.nextLine();
//      scan.useDemiliter(",") = scan.nextLine();
//      scan.next();
//      scan.useDelimiter("\n"); //Default Delimiter

        scan.useDelimiter(","); //We're just telling JVM to use a different token for delimitation, nextLine vs comma
        String friend1 = scan.next();
        String friend2 = scan.next();
        String friend3 = scan.next();

        System.out.println("\n--- Your friends ---");
        System.out.println(friend1);
        System.out.println(friend2);
        System.out.println(friend3);

        scan.close();
    }
}
