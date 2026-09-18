import java.util.Arrays;
import java.util.Scanner;

public class LargestElArray {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Fill your array with 5 numbers");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            System.out.printf("Element %d: ", i+1);
            arr[i] = scan.nextInt();
        }

        int biggest = arr[0];
        for(int i : arr){
            if (i > biggest) {
                biggest = i;
            }
        }

        /*
        int biggest;
        for(int i = 0; i < arr.length; i++){
            for (int j = i+1;  j < arr.length - 1; j++) {
                if(arr[i] > arr[j]) {
                    biggest = arr[i];
                } else {
                    biggest = arr[j]; //without this, if biggest is last element, it compares, fails and never assigns the right answer. Logic fails.
                }
            }
        }
*/

            System.out.println("The Biggest number in your Array " + Arrays.toString(arr) + " is " + biggest);
        scan.close();
    }
}
