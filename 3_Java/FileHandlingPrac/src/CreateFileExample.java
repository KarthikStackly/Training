//1.	Create and Check the File
import java.io.File;
import java.io.IOException;

public class CreateFileExample {

    static void main() {

//        File file = new File("students.txt");
        File nums = new File("students1.txt");

        try {

//            if (file.createNewFile()) {
            if (nums.createNewFile()) {
                System.out.println("File created successfully.");
            } else {
                System.out.println("File already exists.");
            }

            System.out.println("File Name: " + nums.getName());
            System.out.println("File Path: " + nums.getAbsolutePath());
            System.out.println("Readable: " + nums.canRead());
            System.out.println("Writable: " + nums.canWrite());

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
