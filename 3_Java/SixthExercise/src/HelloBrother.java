// CHANGE BOOL TO STRING



import java.util.Arrays;
import java.util.Scanner;

public class HelloBrother {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Is your Array unique? Let's find out.");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            System.out.printf("Element %d: ", i+1);
            arr[i] = scan.nextInt();
        }

        boolean hasDupe = false;
        String dupes = "";

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                hasDupe = true;
                dupes += " " + arr[i];
                }
            }
        }

        if(!hasDupe) {
            System.out.printf("Your array %s is unique%n", Arrays.toString(arr));
        } else {
            System.out.printf("%nYour array %s has duplicates [%s ]%n", Arrays.toString(arr), dupes);
        }
    }
}
