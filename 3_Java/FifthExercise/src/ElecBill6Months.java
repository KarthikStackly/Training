import java.util.Scanner;

public class ElecBill6Months {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Half Yearly Electricity Bill Calculator ***");
        int monthlyBill;
        int finalBill = 0;
        for(int i = 1; i <= 6; i++){
            System.out.printf("Enter Month %d Bill: ", i);
            monthlyBill = scan.nextInt();
            finalBill += monthlyBill;
        }

        System.out.printf("Your Total Bill adds up to INR %d", finalBill);
        scan.close();
    }
}
