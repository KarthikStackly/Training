import java.util.Arrays;
import java.util.Scanner;

public class PayrollProcessing {
    static void main() {
        Scanner scan = new Scanner(System.in);

        /*
        Object[][] payroll = new Object[1][8];
//        I can't use enhanced for loop because I need indexes to verify a logic
        for(int i = 0; i < payroll.length; i++){
            System.out.printf("\nEmployee %d Name: ", i+1);
            payroll[i][0] = scan.next();
            System.out.printf("Please enter %s's salary for the months...%n", payroll[i][0]);
            String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};
//                Started another loop to keep track of positions 1 to 6, in an array of 8. Because 1st and last are for name and totalSalary and the rest should be filled with monthly salary entries
            for(int j = 0; j <= (payroll[i].length - 1); j++) {
                if(j == 7) {
                    payroll[i][7] = (int)payroll[i][1] + (int)payroll[i][2] + (int)payroll[i][3] + (int)payroll[i][4] + (int)payroll[i][5] + (int)payroll[i][6];
                }
                System.out.printf("  %-5s: ", months[j]); //print month from months array
                payroll[i][j+1] = scan.nextInt(); //store user input place
            }
            scan.nextLine(); // Clearing scanner buffer by consuming the new line
        }

        System.out.println(Arrays.deepToString(payroll));

         */

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun"};

        System.out.print("Enter number of employees: ");
        int numEmployees = scan.nextInt();
        scan.nextLine(); // Clearing scanner buffer by consuming the new line

// Separating parallel arrays to keep code clean and away from OutOfBoundsExceptions
        String[] names = new String[numEmployees];
        int[][] salaries = new int[numEmployees][months.length];
        int[] totalSalaries = new int[numEmployees];

//        Collect data frist
        for (int i = 0; i < numEmployees; i++) {
            System.out.printf("%nEmployee %d Name: ", i + 1);
            names[i] = scan.nextLine();

            System.out.printf("Please enter %s's salary for the months...%n", names[i]);
            for (int j = 0; j < months.length; j++) {
                System.out.printf("  %-4s: ", months[j]);
                salaries[i][j] = scan.nextInt();
            }
            scan.nextLine(); // Clearing buffer again after all the integer inputs
        }

// calcing totals for each employee in separate array
        for (int i = 0; i < numEmployees; i++) {
            int sum = 0;
            for (int j = 0; j < months.length; j++) {
                sum += salaries[i][j];
            }
            totalSalaries[i] = sum;
        }

//      finding highestSalary
        int topperIndex = 0;
        for (int i = 1; i < numEmployees; i++) {
            if (totalSalaries[i] > totalSalaries[topperIndex]) {
                topperIndex = i;
            }
        }

        // 4. Printf
        System.out.println("\n--- Payroll Summary ---");
        for (int i = 0; i < numEmployees; i++) {
            System.out.printf("Employee: %-10s | Total Salary: INR %d%n", names[i], totalSalaries[i]);
        }
        System.out.printf("%nHighest Earner: %s with total salary of INR %d%n", names[topperIndex], totalSalaries[topperIndex]);
        scan.close();
    }
}
