import java.util.Scanner;

public class ClassClassClass {

    static void main() {
        Scanner scan = new Scanner(System.in);
        System.out.println("*** Class what's your score!! ***");

        System.out.print("Please enter Student's name : ");
        String studentName = scan.nextLine();
        System.out.print("Please enter the student's class and section : ");
        String studentClass = scan.nextLine();
        System.out.print("How much did you score in Mathematics? : ");
        short marks1 = scan.nextShort();
        System.out.print("How much did you score in Physics? : ");
        short marks2 = scan.nextShort();
        System.out.print("How much did you score in Chemistry? : ");
        short marks3 = scan.nextShort();

        int totalMarks = marks1 + marks2 + marks3;
//        float average = total / 3.0f;
        float average = (float) totalMarks / 3;

        System.out.println("\n--- Student Deets ---");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student Class: " + studentClass);
        System.out.println("First Subject Marks: " + marks1);
        System.out.println("Second Subject Marks: " + marks2);
        System.out.println("Third Subject Marks: " + marks3);

        System.out.println("Total Marks scored by " + studentName + " : " + totalMarks);
        System.out.println(studentName + "'s class Average : " + average);


        scan.close();
    }
}
