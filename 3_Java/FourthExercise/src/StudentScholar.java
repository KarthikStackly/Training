import java.util.Scanner;

public class StudentScholar {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Student Scholarship Eligibility Checking Portal ***");
        System.out.print("Which year? (1st / 2nd / 3rd / 4th) : ");
        String choice = scan.next();
        switch (choice) {
            case "1st":
            case "2nd":
                System.out.println("You are not eligible for Scholarship");
                break;

            case "3rd":
            case "4th":
                System.out.print("Please enter your GPA : ");
                float gpa = scan.nextFloat();
                switch ((int) gpa) {
                    case 10 -> System.out.println("```````` Congratulations! You are eligible for 100% Scholarship! ````````");
                    case 9 -> System.out.println("^^^ Well Done! You are eligible for 75% Scholarship! ^^^");
                    case 8, 7 -> System.out.println("## You are eligible for 60% Scholarship ##");
                    case 6, 5, 4, 3, 2, 1, 0 -> System.out.println("Bro first study properly.");
                    default -> System.out.println("!!! Please enter a valid GPA !!!");
                };
                break;

            default:
                System.out.println("!!! Please enter a valid response !!!");
                break;
        }


        scan.close();
    }
}
