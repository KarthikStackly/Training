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
        System.out.print("Which department? : ");
        String dept = scan.nextLine();
        System.out.print("Employee Designation : ");
        String designation = scan.nextLine();
        System.out.print("How many years of Experience do you have? : ");
        byte experience = scan.nextByte();
        System.out.print("And what is your basic salary? : ");
//        long basicSalary = scan.nextLong();
        double basicSalary = scan.nextDouble();

//        double dearness = (double) basicSalary * 0.10;
        double dearness = basicSalary * 0.10;
        double hra = basicSalary * 0.20;
        double travel = basicSalary * 0.05;
        double grossPay = basicSalary + dearness + hra + travel;
        double pf = basicSalary * 0.12;
        double netPay = grossPay - pf;


        System.out.println("\n--- Employee Details ---");
        System.out.println(employeeName + "'s net Pay is INR" + netPay);


        scan.close();
    }
}
