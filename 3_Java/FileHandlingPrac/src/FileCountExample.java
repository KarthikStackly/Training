//4.	Count character, Spaces and digits

import java.io.FileReader;
import java.io.IOException;

public class FileCountExample {

static void main() {

        int characters = 0;
        int spaces = 0;
        int digits = 0;

        try {
            FileReader reader = new FileReader("student.txt");
            int ch;
            while ((ch = reader.read()) != -1) {
                characters++;
                if (ch == ' ') {
                    spaces++;
                }
                if (Character.isDigit((char) ch)) {
                    digits++;
                }
            }
            reader.close();
            System.out.println("Characters: " + characters);
            System.out.println("Spaces: " + spaces);
            System.out.println("Digits: " + digits);

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
