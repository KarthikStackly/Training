import java.util.Scanner;

public class GuessNumber {
    static void main() {
        Scanner scan = new Scanner(System.in);

        int tries = 0;
        int guess;
        int randomNum = (int) (Math.random() * 10 + 1);

        System.out.println("~Roll Roll Roll~ \nA random number has been generated...");
        System.out.print("Guess the number, it's between 1 and 10 : ");
//Take the initial guess
        guess = scan.nextInt();
        while(true) {
            tries += 1;
//            Increment attempt at the start of loop

            if(guess > randomNum) {
                System.out.println("lower..");
            } else if (guess < randomNum) {
                System.out.println("HIGHER!!");
            } else {
                System.out.printf("BINGO!! Took you %d attempts to guess %d ", tries, randomNum);
                break;
//                Check correct and exit loop
            }

//            Default loop asking again and taking more guesses if the guess is Higher or Lower than the randomNum.
            System.out.print("Try again! : ");
            guess = scan.nextInt();
        }

        scan.close();
    }
}
