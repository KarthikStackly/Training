import java.util.Scanner;

// Class holding the data and calculation logic for individual houses
class House {
    private String houseName;
    private double baseRent;
    private double utilityFee;
    private double maintenanceFee;

    // Constructor
    public House(String houseName, double baseRent, double utilityFee, double maintenanceFee) {
        this.houseName = houseName;
        this.baseRent = baseRent;
        this.utilityFee = utilityFee;
        this.maintenanceFee = maintenanceFee;
    }

    // Rent calculation logic method
    public double calculateTotalRent() {
        return baseRent + utilityFee + maintenanceFee;
    }

    // Getters
    public String getHouseName() {
        return houseName;
    }

    public double getBaseRent() {
        return baseRent;
    }

    public double getUtilityFee() {
        return utilityFee;
    }

    public double getMaintenanceFee() {
        return maintenanceFee;
    }
}

// Main class managing the application logic, menu, and array storage
public class HouseRentCalculator {

    private static House[] houseList = new House[10]; // Array supporting up to 10 houses
    private static int houseCount = 0;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        // Do-while loop to keep menu running until user exits
        do {
            displayMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            // Switch statement to direct menu selections
            switch (choice) {
                case 1:
                    addHouse();
                    break;
                case 2:
                    viewAllRentDetails();
                    break;
                case 3:
                    calculateTotalPropertyRent();
                    break;
                case 4:
                    System.out.println("OK BYE");
                    break;
                default:
                    System.out.println("Invalid selection. Please choose an option between 1 and 4.");
            }
            System.out.println();
        } while (choice != 4);

        scanner.close();
    }

    // Helper method to display menu options
    private static void displayMenu() {
        System.out.println("===== HOUSE RENT CALCULATOR MENU =====");
        System.out.println("1. Add a New House");
        System.out.println("2. View Individual Rent Breakdown");
        System.out.println("3. Calculate Total Rent Across All Houses");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
    }

    // Method to collect details and add a House object to the array
    private static void addHouse() {
        if (houseCount >= houseList.length) {
            System.out.println("Error: Maximum house capacity (" + houseList.length + ") reached.");
            return;
        }

        System.out.print("Enter House Name / Identification: ");
        String name = scanner.nextLine();

        System.out.print("Enter Base Rent (INR): ");
        double baseRent = scanner.nextDouble();

        System.out.print("Enter Utility Fee (INR): ");
        double utilityFee = scanner.nextDouble();

        System.out.print("Enter Maintenance Fee (INR): ");
        double maintenanceFee = scanner.nextDouble();

        // Create new object and store it in array
        houseList[houseCount] = new House(name, baseRent, utilityFee, maintenanceFee);
        houseCount++;

        System.out.println("House successfully added!");
    }

    // Method to iterate through the array and print calculation breakdown
    private static void viewAllRentDetails() {
        if (houseCount == 0) {
            System.out.println("No houses currently registered.");
            return;
        }

        System.out.println("\n--- INDIVIDUAL RENT DETAILS ---");
        for (int i = 0; i < houseCount; i++) {
            House h = houseList[i];
            System.out.printf("House: %s | Base: INR%.2f | Utilities: INR%.2f | Maintenance: INR%.2f | Total Rent: INR%.2f%n",
                    h.getHouseName(),
                    h.getBaseRent(),
                    h.getUtilityFee(),
                    h.getMaintenanceFee(),
                    h.calculateTotalRent());
        }
    }

    // Method to compute total rent for all added houses
    private static void calculateTotalPropertyRent() {
        if (houseCount == 0) {
            System.out.println("No houses currently registered.");
            return;
        }

        double grandTotal = 0;
        for (int i = 0; i < houseCount; i++) {
            grandTotal += houseList[i].calculateTotalRent();
        }

        System.out.printf("Grand Total Monthly Rent collected across %d house(s): INR %.2f%n", houseCount, grandTotal);
    }
}