//2.	Write Student Details
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileExample {

static void main() {

        try {

            FileWriter writer = new FileWriter("students1.txt");
//
//            writer.write("Student ID: 101\n");
//            writer.write("Name: Rahul\n");
//            writer.write("Course: Java\n");
//            writer.write("Marks: 85\n");
//            writer.write("101,Rahul,85\n103,Arun,76\n104,Meena,89\n");
//            writer.write("1\n2\n3\n4\n5\n6\n7\n8\n9\n0\n-1\n-2\n");

            writer.close();

            System.out.println("Data written successfully.");

        } catch (IOException e) {
            System.out.println("Error while writing file.");
        }
    }
}
