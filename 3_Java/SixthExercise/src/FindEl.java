import java.util.Arrays;
import java.util.Scanner;

public class FindEl {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Create an array first");
        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++){
            System.out.printf("Element %d: ", i+1);
            arr[i] = scan.nextInt();
        }

        System.out.printf("Which number do you want to find? : ");
        int search = scan.nextInt();
        boolean found = false;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == search) {
                found = true;
                System.out.printf("%nYour number %d is at position %d in the Array %s%n", search, i+1, Arrays.toString(arr));
                break;
            }
        }

        if (!found){
            System.out.printf("%nI'm sorry, there's no %d in %s%n", search, Arrays.toString(arr));
        }
        scan.close();
    }
}
