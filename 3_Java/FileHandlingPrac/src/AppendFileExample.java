//3.	Append Data to a File

import java.io.FileWriter;
import java.io.IOException;

public class AppendFileExample {

static void main() {

        try {

            FileWriter writer = new FileWriter("employees.txt", true);

            writer.write("108 - Rekha\n");
            writer.write("110 - Sushma\n");

            writer.close();

            System.out.println("Data appended successfully.");

        } catch (IOException e) {
            System.out.println("Error while appending data.");
        }
    }
}
