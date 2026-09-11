import java.util.Scanner;

public class SpotExercise1 {

/*
    static void main() {
        Scanner scan = new Scanner(System.in);

//      1. Greatest Number
        System.out.println("*** Greatest number using if-else ladder ***");
        System.out.print("Enter 1st number : ");
        int firstNum = scan.nextInt();
        System.out.print("Enter 2nd number : ");
        int secondNum = scan.nextInt();

        if (firstNum > secondNum) {
            System.out.println(firstNum + " is greater than " + secondNum);
        } else if (secondNum > firstNum) {
            System.out.println(secondNum + " is greater than " + firstNum);
        } else {
            System.out.println("Both numbers are equal");
        }

//      2. Odd Even
        System.out.println("\n*** Odd or Even ***");

        System.out.print("Enter any number : ");
        int oddEven = scan.nextInt();
        if(oddEven == 0) {
            System.out.println(oddEven + " is Zero!");
        } else if (oddEven % 2 == 0) {
            System.out.println(oddEven + " is an Even number");
        } else {
            System.out.println(oddEven + " is an Odd number");
        }


//       3. Check Login
        System.out.println("\n*** Check Login ***");
        String user = "stackly";
        String pwd = "stacklystackly";

        System.out.print("Enter username : ");
        String username = scan.nextLine();
        if(username.equals(user)) {
            System.out.print("Enter password : ");
            String password = scan.nextLine();
            if (password.equals(pwd)) {
                System.out.println("SUCCESSFUL LOGIN! WELCOME TO DASHBOARD");
            } else {
                System.out.println("XXX Wrong Password XXX");
            }
        } else {
            System.out.println("XXX Wrong Username XXX");
        }

//      4. Loan Approval
        System.out.println("\n*** Loan Approval ***");

        System.out.print("Are you currently employed? : ");
        boolean employmentStatus = scan.nextBoolean();
        if (!employmentStatus) {
            System.out.println("You are not eligible for a CIBIL Score");
        } else {
            System.out.print("What is your salary? : ");
            int salary = scan.nextInt();
            System.out.print("What is your CIBIL Score");
            short cibil = scan.nextShort();
            if (salary > 50000) {
                if (cibil > 700) {
                    System.out.println("!!! You are approved for a loan at 20% interest !!!");
                }

                if (cibil <= 700) {
                    System.out.println("! Your loan can be approved at 30% interest !");
                }
            }

            if (salary <= 50000) {
                System.out.println("At 50% interest, your loan can be approved instantly...");
            }
        }

//      5. Blood Donation
        System.out.println("*** Blood Donation Eligibility ***");
        System.out.print("Enter your Age in Years : ");
        short age = scan.nextShort();
        System.out.print("Enter your weight in Kilos (Kgs) : ");
        short weight = scan.nextShort();
        if(age > 70) {
            System.out.println("Sorry, you are not eligible to donate blood. ");
        } else if (weight > 150) {
            System.out.println("Sorry, you must take care of yourself before donating blood. ");
        } else {
            System.out.println("Thank you for saving lives!");
        }


        scan.close();
    }
*/

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // 1. Greatest number using if-else ladder
        System.out.println("--- 1. Greatest Number ---");
        System.out.print("Enter three numbers: ");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if (a >= b && a >= c) {
            System.out.println(a + " is the greatest.");
        } else if (b >= a && b >= c) {
            System.out.println(b + " is the greatest.");
        } else {
            System.out.println(c + " is the greatest.");
        }

        // 2. Positive/Negative/Zero and Odd/Even
        System.out.println("\n--- 2. Number Properties (Sign & Parity) ---");
        System.out.print("Enter an integer: ");
        int num = scan.nextInt();

        if (num > 0) {
            System.out.println(num + " is Positive.");
        } else if (num < 0) {
            System.out.println(num + " is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }

        if (num % 2 == 0) {
            System.out.println(num + " is Even.");
        } else {
            System.out.println(num + " is Odd.");
        }

        // 3. Username and Password Login Functionality
        System.out.println("\n--- 3. Login Validation ---");
        scan.nextLine(); // Consume leftover newline
        System.out.print("Enter username: ");
        String username = scan.nextLine();
        System.out.print("Enter password: ");
        String password = scan.nextLine();

        String correctUser = "admin";
        String correctPass = "secret123";

        if (username.equals(correctUser)) {
            if (password.equals(correctPass)) {
                System.out.println("Login Successful!");
            } else {
                System.out.println("Login Failed: Incorrect password.");
            }
        } else {
            System.out.println("Login Failed: Username not found.");
        }

        // 4. Loan Eligibility using Nested If
        System.out.println("\n--- 4. Loan Eligibility (Nested If) ---");
        System.out.print("Are you employed? (true/false): ");
        boolean isEmployed = scan.nextBoolean();

        if (isEmployed) {
            System.out.print("Enter monthly salary: ");
            double salary = scan.nextDouble();
            if (salary >= 35000) {
                System.out.print("Enter CIBIL score: ");
                int cibil = scan.nextInt();
                if (cibil >= 700) {
                    System.out.println("Loan Approved!");
                } else {
                    System.out.println("Loan Rejected: CIBIL score is below 700.");
                }
            } else {
                System.out.println("Loan Rejected: Salary is below the 35,000 threshold.");
            }
        } else {
            System.out.println("Loan Rejected: Applicant must be employed.");
        }

        // 5. Blood Donation Eligibility
        System.out.println("\n--- 5. Blood Donation Eligibility ---");
        System.out.print("Enter age: ");
        int age = scan.nextInt();
        System.out.print("Enter weight (in kg): ");
        double weight = scan.nextDouble();

        if (age >= 18 && age <= 65) {
            if (weight >= 50) {
                System.out.println("Eligible for blood donation!");
            } else {
                System.out.println("Not eligible: Weight must be at least 50 kg.");
            }
        } else {
            System.out.println("Not eligible: Age must be between 18 and 65 years.");
        }

        scan.close();
    }
    }
