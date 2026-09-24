import java.util.Scanner;
//Implemented without Inheritance...
//Supposed to be Parent class holding all the user data that we are going to use...
class Account {
    String name;
    double balance;
    int pin;

    Account(String name, double balance, int pin) { //Constructor to initialize with data as soon as the Object is created
        this.name = name;
        this.balance = balance;
        this.pin = pin;
    }
}

//Auth class
class Authentication {
    boolean authenticate(Account account, int inputPin) {
        if(inputPin == account.pin) {
            System.out.println("*** Access Granted ***");
//            Perform Operations
            return true;
        } else {
            System.out.println("XXX Access Denied XXX");
            return false;
        }
    }
}

//Withdrawal Deposit Logic class
class Transaction {
//    Suppposed to Directly update the Account
    void deposit(Account account, double amount){ // passing as parameters, whatever I need to finish the transaction.
        if (amount <= 0) {
            System.out.println("Amount needs to be more than 0 to be Deposited.");
        } else {
            account.balance += amount;
            System.out.println("INR " + amount + " has been Deposited in your account.");
            System.out.println("Your current balance is INR " + account.balance);
        }
    };

    void withdraw(Account account, double amount){
        if(amount > account.balance) {
            System.out.println("Amount cannot be higher than your Account balance.");
        } else if(amount <= 0){
            System.out.println("Withdrawal Amount needs to be greater than 0.");
        } else {
            account.balance -= amount;
            System.out.println("INR " + amount + " has been Withdrawn from your account.");
            System.out.println("Your current balance is INR " + account.balance);
        }
    }
}


class ATMTransactionProg {
    static void main() {
//      Staging area
        Scanner scan = new Scanner(System.in);

//        Instantiating
        Account karAccount = new Account("Karthik", 5000, 1234); //My Object
        Authentication karAuth = new Authentication();
        Transaction karTran = new Transaction();

//        Interaction
        System.out.printf("Hey %s! Please enter your 4 digit PIN: ", karAccount.name);
        int karPin = scan.nextInt();
        if(karAuth.authenticate(karAccount, karPin)){
            karTran.withdraw(karAccount, 2000);
            karTran.deposit(karAccount, 800);
            karTran.deposit(karAccount, -800);
            karTran.withdraw(karAccount, 0);
        }

        scan.close();

    }
}
