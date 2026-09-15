import java.util.Scanner;

public class EmpPayrollProcessing {
    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Employee Payroll Processing ***");

        System.out.print("Employee Name : ");
        String employeeName = scan.nextLine();
        System.out.print("Employee ID : ");
        int employeeID = scan.nextInt();
        scan.nextLine();
        System.out.print("Which department? (IT or Non IT) : ");
        String dept = scan.nextLine();
        System.out.print("Employee Designation (Manager / Developer / Lead / <Enter yours if none of these apply>) : ");
        String designation = scan.nextLine();
        System.out.print("How many years of Experience do you have? : ");
        byte experience = scan.nextByte();
        System.out.print("And what is your basic salary? : ");
//        long basicSalary = scan.nextLong();
        double basicSalary = scan.nextDouble();

//      Calculate Increment based on Experience and Department
        double increment = 0;
        if (dept.equalsIgnoreCase("IT")) {
            if (experience >= 5) {
                increment = basicSalary * 0.15; // 15% for experienced IT
            } else {
                increment = basicSalary * 0.08; // 8% for junior IT
            }
        } else {
            if (experience >= 5) {
                increment = basicSalary * 0.10; // 10% for experienced non-IT
            } else {
                increment = basicSalary * 0.05; // 5% for junior non-IT
            }
        }

//      Calculate Bonus based on Designation
        double bonus = 0;
        if (designation.equalsIgnoreCase("Manager")) {
            bonus = 20000;
        } else if (designation.equalsIgnoreCase("Developer") || designation.equalsIgnoreCase("Lead")) {
            bonus = 10000;
        } else {
            bonus = 5000;
        }

//      Base Allowances & Deductions
//      double dearness = (double) basicSalary * 0.10;
        double dearness = basicSalary * 0.10;
        double hra = basicSalary * 0.20;
        double travel = basicSalary * 0.05;
        double pf = basicSalary * 0.12;

//      Calculate Final Pay
        double grossPay = basicSalary + increment + dearness + hra + travel;
        double netPay = (grossPay - pf) + bonus;

        // Output
        System.out.println("\n--- Employee Details ---");
        System.out.println("Employee Name : " + employeeName + " (ID: " + employeeID + ")");
        System.out.println("Increment     : INR " + increment);
        System.out.println("Bonus         : INR " + bonus);
        System.out.println("Net Pay       : INR " + netPay);

        scan.close();
    }
}
