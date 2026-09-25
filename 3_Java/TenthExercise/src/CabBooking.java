interface Cab {
    double BASE_FARE = 10.00; //public static final...

    boolean book();
    double calcFare();
}

class Auto implements Cab {
    private double pricePerKM = 16.00;
    private double distanceTravelled;
    private boolean isAvailable = true;

    Auto(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public boolean book() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Auto booked successfully!");
            return true;
        } else {
            System.out.println("Auto is already booked!");
            return false;
        }
    }

    @Override
    public double calcFare() {
        return BASE_FARE + (distanceTravelled * pricePerKM);
    }
}

class Sedan implements Cab {
    private double pricePerKM = 25.00;
    private double distanceTravelled;
    private boolean isAvailable = true;

    Sedan(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    @Override
    public boolean book() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Sedan booked successfully!");
            return true;
        } else {
            System.out.println("Sedan is already booked!");
            return false;
        }
    }

    @Override
    public double calcFare() {
        return BASE_FARE + (distanceTravelled * pricePerKM);
    }
}

public class CabBooking {
    static void main() {
        Cab myAuto = new Auto(12.5);
        Cab mySedan = new Sedan(12.5);

        System.out.println("--- Booking Auto ---");
        myAuto.book();
        System.out.println("Total Auto Fare: $" + myAuto.calcFare());

        System.out.println("\n--- Booking Sedan ---");
        mySedan.book();
        System.out.println("Total Sedan Fare: $" + mySedan.calcFare());
    }
}