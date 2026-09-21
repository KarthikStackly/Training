import java.util.Scanner;

public class StudentProgressReport {
    static void main() {
        Scanner scan = new Scanner(System.in);
//I have intentionally used two separate Arrays, one to store names and the other for the Marks. The cons of this approach is that I have incomplete/incorrect final result because of storing Average in the same Array, given the Homogeneity of Arrays, I have stored what is supposed to be a double variable in an int array.
        int totalStudents = 3;
        String[] students = new String[totalStudents];

//      X rows: no of students decided by me in above line
//      5 columns: [0]=Maths, [1]=Physics, [2]=Chemistry, [3]=Total, [4]=Average
        int[][] marks = new int[totalStudents][5];

        for (int i = 0; i < students.length; i++) {
            System.out.printf("%nEnter Student %d Name: ", i + 1);
            students[i] = scan.nextLine();
            System.out.printf("Okay, what are %s's scores in...%n", students[i]);

            for (int j = 0; j < marks[i].length; j++) {
                if (j == 3) {
                    //TOtal
                    marks[i][j] = marks[i][0] + marks[i][1] + marks[i][2];
//                    marks[i][j] = marks[i][marks[i].length-2] + marks[i][1] + marks[i][2];
                } else if (j == 4) {
//                    Average
//                    marks[i][j] = marks[i][marks.length-2] / (marks[i].length - 2);
                    marks[i][j] = marks[i][3] / 3;
                } else {
//                    String array declared so I can loop in this and display them before taking input for each and store
                    String[] subjectNames = {"Maths", "Physics", "Chemistry"};
                    System.out.printf("  %-10s: ", subjectNames[j]);
                    marks[i][j] = scan.nextInt();
                }
            }
            scan.nextLine(); // Clearing scanner buffer by consuming the new line
        }

        System.out.println("\n=========================================================================");
        System.out.println("                        STUDENT PROGRESS REPORT                          ");
        System.out.println("=========================================================================");
        System.out.printf("%-15s %-10s %-10s %-10s %-10s %-10s%n","Name", "Maths", "Physics", "Chemistry", "Total", "Average");
        System.out.println("-------------------------------------------------------------------------");

        int highestTotal = -1;
        int topperIndex = -1;

        for (int i = 0; i < students.length; i++) {
//          Print first, and calc topper on the fly later in the same loop instead of a different loop to identify topper

            System.out.printf("%-15s %-10d %-10d %-10d %-10d %-10d%n",
                    students[i],
                    marks[i][0], // Maths
                    marks[i][1], // Physics
                    marks[i][2], // Chemistry
                    marks[i][3], // Total
                    marks[i][4]  // Average
            );

//          Calc Topper
            if (marks[i][3] > highestTotal) {
                highestTotal = marks[i][3];
                topperIndex = i;
            }
        }

        System.out.println("=========================================================================");

        if (topperIndex != -1) {
            System.out.printf("%n🏆 TOPPER OF THE CLASS: %s with a Total of %d marks!%n",
                    students[topperIndex], marks[topperIndex][3]);
        }

        scan.close();
    }
}