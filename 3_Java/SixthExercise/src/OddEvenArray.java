import java.util.Arrays;
import java.util.Scanner;

public class OddEvenArray {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Let's check Odd Evens. Fill your array first");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            System.out.printf("Element %d: ", i+1);
            arr[i] = scan.nextInt();
        }

        String oddNums = "";
        int odds = 0;
        String evenNums = "";
        int evens = 0;
        int zeros = 0;

        for (int i : arr) {
            if( i == 0) {
                zeros++;
            } else if (i % 2 == 0) {
                evens++;
                evenNums += " " + i;
            } else {
                odds++;
                oddNums += " " + i;
            }
        }

        System.out.printf("Your Array %s has %d Even and %d Odd Numbers", Arrays.toString(arr), evens, odds);
        if(zeros > 0) {
            System.out.printf(". As well as %d zeros.", zeros);
        }

        System.out.printf("%nEvens => [%s ] and Odds => [%s ]", evenNums, oddNums);
        scan.close();
    }
}
