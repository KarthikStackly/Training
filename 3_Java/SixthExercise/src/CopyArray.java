import java.util.Arrays;
import java.util.Scanner;

public class CopyArray {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter 5 numbers to an array");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
//        for (int i : arr){
//            i = scan.nextInt();
            System.out.printf("Element %d: ", i+1);
            arr[i] = scan.nextInt();
        }

        System.out.println("Your array is as follows: ");
        System.out.print("[");
        for(int i : arr) {
            System.out.printf(" %d ", i);
        }
        System.out.println("]");

        System.out.println("Now Let's try to copy the array");

        int[] copyArr = new int[arr.length];

//        for(int i : arr) {
//        for (int j : copyArr) {
//                j = i; // I can't do this because I'm trying to equate these values. And the default elements in a new undefined array is 0
//        for(int i = 0, j = 0; i < arr.length && j < copyArr.length; i++, j++){}

        for(int i = 0; i < arr.length; i++){ //since both arrays are of same length, I can perform this using a single variable
            copyArr[i] = arr[i];
        }
        System.out.println("And Here's your array copied => " + Arrays.toString(copyArr));
        scan.close();
    }
}
