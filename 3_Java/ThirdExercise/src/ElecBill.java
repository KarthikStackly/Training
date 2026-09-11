import java.util.Scanner;

public class ElecBill   {

    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Welcome to Bharat Power Bill ***");

        System.out.print("Please enter your alphanumeric Consumer ID : ");
        String consumerId = scan.next();
        System.out.print("Please enter the Consumer Number : ");
        long consumerNumber = scan.nextLong();
        scan.nextLine();
//        Place the nextLine right after the scanner appearing before a nextInt
        System.out.print("What is the type of building associated with the current ID? : ");
        String buildingType = scan.nextLine();
        System.out.print("Number of units in the previous month : ");
        int previousUnits = scan.nextInt();
        System.out.print("Number of units in the current month : ");
        int currentUnits = scan.nextInt();

        System.out.println("\n--- Consumer Details ---");
        System.out.println("Consumer ID: " + consumerId);
        System.out.println("Consumer Number: " + consumerNumber);
        System.out.println("Building Type: " + buildingType);
        System.out.println("Previous Month UNits: " + previousUnits);
        System.out.println("Current Month UNits: " + currentUnits);

        scan.close();
    }
}
