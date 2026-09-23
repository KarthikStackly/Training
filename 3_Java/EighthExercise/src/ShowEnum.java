import java.util.Scanner;

public class ShowEnum {
    static void main() {
        Scanner scan = new Scanner(System.in);

        enum Day {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        Day today = Day.SUNDAY;

        String x = switch(today) {
//            case WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY -> System.out.println("it's the weekday!!");
            case WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY -> "it's the weekday!!";
//            case MONDAY, TUESDAY -> System.out.println("Weekend!!!!");
            case MONDAY, TUESDAY -> "Weekend!!!!";
        };

        System.out.println(x);

        scan.close();
    }
}
