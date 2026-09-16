import java.util.Scanner;

public class MonthlyDays {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Let's Calculate number of Days in a Month ***");
        System.out.print("Enter a Month, either by name or number from 1 to 12 : ");
        String month = scan.next().toLowerCase();

        switch (month){
            case "1":
            case "jan":
            case "january":
            case "3":
            case "mar":
            case "march":
            case "5":
            case "may":
            case "7":
            case "jul":
            case "july":
            case "8":
            case "aug":
            case "august":
            case "10":
            case "oct":
            case "october":
            case "12":
            case "dec":
            case "december":
                System.out.printf("%s has 31 days", month);
                break;

            case "4":
            case "apr":
            case "april":
            case "6":
            case "jun":
            case "june":
            case "9":
            case "sep":
            case "september":
            case "11":
            case "nov":
            case "november":

                System.out.printf("%s has 30 days", month);
                break;

            case "2":
            case "feb":
            case "february":
                System.out.print("Also enter which Year this is for? : ");
                int year = scan.nextInt();
                int days = 28;
                if (year % 4 == 0) {
                    if(year % 100 == 0){
                        if(year % 400 == 0) {
                            days += 1;
                        }
                    }
                }

                System.out.printf("%s in the year %d has %d Days", month.toUpperCase(), year, days);
                break;

            default:
                System.out.println("Please enter a valid input for month!");
                break;
        }

        scan.close();
    }
}
