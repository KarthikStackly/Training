import java.util.Scanner;

public class ShowEnum1 {
    static void main() {
//        Scanner scan = new Scanner(System.in);

        enum TrafficLights {
//            First, basic setup...
            RED("STOP!!!"), //supposed to mimic constructor calls, with a String as parameters
            YELLOW("Ready..."),
            GREEN("__ GO  __");

            final String action; //declaring the String to be used as parameter

            TrafficLights(String action){ //defining the constructor
                this.action = action;
            }

          String getAction() { // defining a getter method that we would use later
                return this.action;
          }

        }

//        Now I write my program which can use this enum.

        for (int i = 10; i >= 0; i--) {
            TrafficLights currentSignal;
            switch (i) {
//                case 10,9,8,7,6,5 -> currentSignal = TrafficLights.RED;
                case 4, 3, 2, 1-> currentSignal = TrafficLights.YELLOW;
                case 0 -> currentSignal = TrafficLights.GREEN;
                default -> currentSignal = TrafficLights.RED;
            }
            System.out.printf("%n%s --- %d", currentSignal, i);
        }

//        scan.close();
    }
}
