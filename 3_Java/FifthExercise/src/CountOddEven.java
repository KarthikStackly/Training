public class CountOddEven {
    static void main() {
        System.out.println("*** Count ODD EVEN ***");
        int odds = 0;
        int evens = 0;

        for(int i = 1; i <= 51; i++) {
            if(i % 2 == 0) {
                evens++;
            } else {
                odds++;
            }
        }

        System.out.println("Total number of Evens: " + evens);
        System.out.println("Total number of Odds: " + odds);

    }
}
