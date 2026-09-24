import java.util.Scanner;

class RentalService {
    String carName;
    int duration; //hours or days in the same int

    RentalService(String carName, int duration) {
        this.carName = carName;
        this.duration = duration;
    }

    double calcRent() { //setting this up to override later
        return 0.00;
    }
}

class HourlyRental extends RentalService {
    double hourlyRate = 100.00;

    HourlyRental(String carName, int hours) {
        super(carName, hours);
    }

    @Override
    double calcRent() {
        return hourlyRate * duration;
    }
}

class DailyRental extends RentalService {
    double dailyRate = 3000.00;
    DailyRental(String carName, int days) {
        super(carName, days);
    }

    @Override
    double calcRent() {
        return dailyRate * duration;
    }
}

public class CarRental {
    static void main() {
        Scanner scan = new Scanner(System.in);
        int userChoice;

        double driverFeePerDay = 500.0;
        boolean driverAvailable = true;

        System.out.println("*** Welcome to RentalServices Inc");
        do {
            System.out.println("\nRENTALS MENU");
            System.out.print("1. Rent per Hour\n2. Rent per Day\n3. Exit\nChooose one option : ");
            userChoice = scan.nextInt();

            switch (userChoice){
                case 1 -> {
                    System.out.print("For how many hours? : ");
                    int hours = scan.nextInt();

                    HourlyRental karthik = new HourlyRental("Ambassador", hours);
                    double total = karthik.calcRent();

                    System.out.println("Total Rental Cost : INR " + total);
                }

                case 2-> {
                    System.out.print("For how many days? : ");
                    int days = scan.nextInt();

                    DailyRental karthik = new DailyRental("Sedan", days);
                    double total = karthik.calcRent();

                    System.out.print("If you need a Driver, I can check... (0 for No | 1 for Yes) : ");
                    int driverNeeded = scan.nextInt();

                    if(driverNeeded == 1) {
                        if(driverAvailable) {
                            double driverCost = driverFeePerDay * days;
                            total += driverCost;
                            System.out.println("Driver Fee INR " + driverCost + " Added for " + days + " days.");
                            driverAvailable = false;
                        } else {
                            System.out.println("Sorry, Driver is unavailable. ");
                        }
                    }
                    System.out.println("Total Rent adds up to INR " + total);
                }

//                default -> System.out.println("Please enter a valid choice!");
            }

        } while(userChoice != 3);

        System.out.println("Alright, don't hesitate to reach out!");

        scan.close();
    }
}
