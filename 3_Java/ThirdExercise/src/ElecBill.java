import java.util.Scanner;

public class ElecBill {

    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Welcome to Bharat Power Bill ***");
        System.out.print("Please enter your alphanumeric Consumer ID : ");
        String consumerId = scan.next();
        System.out.print("Please enter the Consumer Number : ");
        long consumerNumber = scan.nextLong();
        scan.nextLine();
        // Clearing Buffer - Place the nextLine right after the scanner appearing before a nextInt

        System.out.print("What is the type of building associated with the current ID? "
                + "(Residential / Commercial / Industrial & Institutional) : ");
        String buildingType = scan.nextLine().trim();

        System.out.print("Domestic / Multi-Tenant / Small Commercial / Large Commercial "
                + "/ Small Scale / Large Scale\nWhich subcategory? : ");
        String subcategory = scan.nextLine().trim();

        System.out.print("Number of units in the previous month : ");
        int previousUnits = scan.nextInt();

        System.out.print("Number of units in the current month : ");
        int currentUnits = scan.nextInt();

        int unitsConsumed = currentUnits - previousUnits;

        if (unitsConsumed < 0) {
            System.out.println("!!! Current Units cannot be less than Previous Units !!!");
            unitsConsumed = 0;
        }

        double energyCharge = 0.0;
        double fixedCharge = 0.0;
        double concession = 0.0;
        boolean isValidInput = true;

//      Slab Calc & Concession Logic

        if (buildingType.equalsIgnoreCase("Residential")) {

            if (subcategory.equalsIgnoreCase("Domestic")) {
                // Tiered Slabs
                if (unitsConsumed <= 100) {
                    energyCharge = unitsConsumed * 2.50;
                    concession = energyCharge * 0.20; // 20% Subsidy/Concession for low usage
                } else if (unitsConsumed <= 200) {
                    energyCharge = (100 * 2.50) + ((unitsConsumed - 100) * 4.00);
                    concession = 50.0; // Flat ₹50 Concession
                } else if (unitsConsumed <= 500) {
                    energyCharge = (100 * 2.50) + (100 * 4.00) + ((unitsConsumed - 200) * 6.00);
                    concession = 0.0;
                } else {
                    energyCharge = (100 * 2.50) + (100 * 4.00) + (300 * 6.00) + ((unitsConsumed - 500) * 7.50);
                    concession = 0.0;
                }
                fixedCharge = 50.0;

            } else if (subcategory.equalsIgnoreCase("Multi-Tenant")) {
                energyCharge = unitsConsumed * 6.00;
                fixedCharge = 100.0;
                concession = (unitsConsumed <= 200) ? energyCharge * 0.10 : 0.0; // 10% concession under 200 units
            } else {
                isValidInput = false;
            }

        } else if (buildingType.equalsIgnoreCase("Commercial")) {

            if (subcategory.equalsIgnoreCase("Small Commercial")) {
                if (unitsConsumed <= 100) {
                    energyCharge = unitsConsumed * 5.00;
                } else if (unitsConsumed <= 300) {
                    energyCharge = (100 * 5.00) + ((unitsConsumed - 100) * 7.00);
                } else {
                    energyCharge = (100 * 5.00) + (200 * 7.00) + ((unitsConsumed - 300) * 9.00);
                }
                fixedCharge = 150.0;
                concession = 0.0; // Commercial gets no concession

            } else if (subcategory.equalsIgnoreCase("Large Commercial")) {
                energyCharge = unitsConsumed * 9.00;
                fixedCharge = 1000.0;
                concession = 0.0;
            } else {
                isValidInput = false;
            }

        } else if (buildingType.equalsIgnoreCase("Industrial & Institutional") || buildingType.equalsIgnoreCase("Industrial")) {

            if (subcategory.equalsIgnoreCase("Small Scale")) {
                if (unitsConsumed <= 500) {
                    energyCharge = unitsConsumed * 5.00;
                    concession = energyCharge * 0.10; // 10% Small Industry Incentive
                } else {
                    energyCharge = (500 * 5.00) + ((unitsConsumed - 500) * 7.00);
                    concession = 0.0;
                }
                fixedCharge = 300.0;

            } else if (subcategory.equalsIgnoreCase("Large Scale")) {
                energyCharge = unitsConsumed * 11.00;
                fixedCharge = 2000.0;
                concession = 0.0;
            } else {
                isValidInput = false;
            }

        } else {
            isValidInput = false;
        }

        if (!isValidInput) {
            System.out.println("!!! Invalid Building Type or Subcategory !!!");
            scan.close();
            return;
        }

//      Final Deduction Logic

        double grossSubtotal = energyCharge + fixedCharge;

        // Remove concession from gross subtotal
        double netAmountAfterConcession = grossSubtotal - concession;
        if (netAmountAfterConcession < 0) {
            netAmountAfterConcession = 0; // Guard against negative bill
        }

        // Apply 5% Electricity Duty / Tax on net payable amount
        double tax = netAmountAfterConcession * 0.05;
        double finalAmount = netAmountAfterConcession + tax;

//      Final Prints

        System.out.println("\n--- Electricity Bill Breakdown ---");
        System.out.println("Consumer ID       : " + consumerId);
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

        scan.close();
    }
}