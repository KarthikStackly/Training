import java.util.Arrays;
import java.util.Scanner;

public class PatientsTemperatures {
    static void main() {
        Scanner scan = new Scanner(System.in);

//        int[][] To get a heterogeneous Array, I have to declare an array of type Object
        Object[][] patientDeets = new Object[2][4];

        for (int i = 0; i < patientDeets.length; i++) {
//Since I have declared a single array and not comparing indices at any point to keep any track, I only need single for loop (as opposed to a nested for loop).. Like, I could have used two separate homogeneous arrays, one for names and one for temps and used index of one to identify and loop the other but instead I have implemented a heterogenous array by declaring the array of type Object
            System.out.print("\nPlease enter the patient name: ");
            patientDeets[i][0] = scan.next();

            System.out.printf("Please enter %s's temperatures taken in °F at...%n", patientDeets[i][0]);

                System.out.print("Morning: ");
                patientDeets[i][1] = scan.nextDouble();
                System.out.print("Afternoon: ");
                patientDeets[i][2] = scan.nextDouble();
                System.out.print("Night: ");
                patientDeets[i][3] = scan.nextDouble();

        }

        double feverThreshold = 100.4; // Temperature threshold for admission because no strict parameters given
        System.out.println("\n--- PATIENTS DATABASE ---");

        for (int i = 0; i < patientDeets.length; i++) {
            String name = (String) patientDeets[i][0];

            // Cast Object elements back to double to be able to calculate
            double morning = (double) patientDeets[i][1];
            double afternoon = (double) patientDeets[i][2];
            double night = (double) patientDeets[i][3];

            double averageTemp = (morning + afternoon + night) / 3.0;
            boolean hasHighFever = morning >= feverThreshold || afternoon >= feverThreshold || night >= feverThreshold;

            System.out.printf("%nPatient: %s%n", name);
            System.out.printf("Average Temperature: %.1f°F%n", averageTemp);

            // Deciding factor
//            if (hasHighFever && averageTemp >= 99.5) {
            if (hasHighFever || averageTemp >= 99.5) {
                System.out.println("Status: ADMITTED (High fever)");
            } else {
                System.out.println("Status: DISCHARGED");
            }
        }


        scan.close();
    }
}
