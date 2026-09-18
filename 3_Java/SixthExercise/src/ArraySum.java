import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArraySum {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 5 numbers in the array");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            System.out.printf("Element %d: ", i+1);
            arr[i] = scan.nextInt();
        }

        int sum = 0;
        for(int i: arr){
            sum += i;
        }
        System.out.println("\nThe sum of numbers in your Array " + Arrays.toString(arr) + " is " + sum);

        scan.close();
    }
}
