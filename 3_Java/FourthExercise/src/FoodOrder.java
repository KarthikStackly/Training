import java.util.Scanner;

public class FoodOrder {
    static void main() {
        Scanner scan = new Scanner(System.in);
        double subtotal = 0;
        double finalBill = 0;
        double tax = 0.05;
        System.out.println("*** Welcome to Stackly Canteen ***");
        System.out.println("Please select from menu below: ");
        System.out.print("1. Pizza\n2. Burgers\n3. Maggi\n4. Checkout\n =====> : ");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                subtotal += 350;
                System.out.println("Would you like to add any sides?");
                System.out.print("1. Garlic Bread\n2. Coke\n3. Checkout\n=====> : ");
                int pizzaSides = scan.nextInt();
                switch (pizzaSides){
                    case 1 ->  subtotal += 150;
                    case 2 -> subtotal += 50;
                    case 3 -> subtotal += 0;
                    default -> System.out.println("Please enter a valid choice");
                };
                break;

            case 2:
                System.out.println("Would you like to add any sides?");
                System.out.print("1. Fries\n2. Pepsi\n3. Extra Cheese\n4. Checkout\n =====> : ");
                int burgerSides = scan.nextInt();
                switch (burgerSides){
                    case 1 -> subtotal += 100;
                    case 2 -> subtotal += 50;
                    case 3 -> subtotal += 10;
                    case 4 -> subtotal += 0;
                    default -> System.out.println("Please enter a valid choice");
                }
                break;

            case 3:
                System.out.print("Would you like it Soupy? : ");
                String maggi = scan.next();
                if(maggi.equalsIgnoreCase("Yes")) {
                    subtotal += 250;
                } else {
                    subtotal += 200;
                }
                break;

            case 4: break;

            default:
                System.out.println("Please enter a valid choice from above options only!");
                break;
        }

        finalBill = subtotal + (subtotal * tax);
/*
        System.out.println("\n--- Final Bill Breakdown ---");
        System.out.println("Total Cost        : " + subtotal);
        System.out.println("Consumer Number   : " + consumerNumber);
        System.out.println("Building Type     : " + buildingType + " (" + subcategory + ")");
        System.out.println("Units Consumed    : " + unitsConsumed + " kWh");
        System.out.println("----------------------------------");
        System.out.printf("Energy Charge     : ₹%.2f%n", energyCharge);
        System.out.printf("Fixed Charge      : ₹%.2f%n", fixedCharge);
        System.out.printf("Gross Subtotal    : ₹%.2f%n", grossSubtotal);
        System.out.printf("Concession        : -₹%.2f%n", concession);
        System.out.printf("Net Chargeable    : ₹%.2f%n", netAmountAfterConcession);
        System.out.printf("GST               : ₹%.2f%n", tax);
        System.out.println("----------------------------------");
        System.out.printf("FINAL BILL AMOUNT : ₹%.2f%n", finalAmount);
*/
        System.out.println("Bill to pay : INR " + finalBill);

        scan.close();
    }
}
