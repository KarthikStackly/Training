import java.util.Scanner;

public class Banking {
    static void main() {
        Scanner scan = new Scanner(System.in);
        int balance = 5000;
        int minBal = 500;
        System.out.println("*** Welcome to IFDC Bank  ***");
        System.out.print("1. Withdraw\n2. Deposit\n3. Check Balance\n4. Contact Support\n=====> : ");
        int choice = scan.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Please enter the amount to Withdraw : ");
                int withdraw = scan.nextInt();
                if(balance - withdraw >= minBal) {
                    balance -= withdraw;
                    System.out.println("Withdrawal of amount INR " + withdraw + " successful. ");
                } else {
                    System.out.println("You need to maintain minimum balance of INR " + minBal);
                }
                System.out.println("Your current balance is INR " + balance);
                break;

            case 2:
                System.out.println("Please enter the amount to Deposit : ");
                int deposit = scan.nextInt();
                balance += deposit;
                System.out.println("Deposit of amount INR " + deposit + "Successful!");
                System.out.println("Your updated balance is INR " + balance);
                break;

            case 3:
                System.out.println("Your current balance is INR " + balance);
                break;

            case 4:
                System.out.println("What is this issue regarding?");
                System.out.print("1. Credit Card\n2. Address Change\n3. Close the account\n4. Apply for a loan\n=====> : ");
                int supportChoice = scan.nextInt();
                switch (supportChoice) {
                    case 1, 2, 3, 4 -> System.out.println("Our customer support executive will contact you within 24 hours. ");
                    default -> System.out.println("!!! Please enter a valid choice 1 to 4 only... !!!");
                };
                break;

            default:
                System.out.println("!!! Please select 1 to 4 only... !!!");
                break;
        }

        scan.close();
    }
}
