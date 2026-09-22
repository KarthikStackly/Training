//6.	Find the Longest word

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LongestWord {

    static void main() {
        String longestWord = "";
        try {
            BufferedReader br =
                    new BufferedReader(new FileReader("student.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }

            br.close();
            System.out.println("Longest word: " + longestWord);
            System.out.println("Length: " + longestWord.length());

        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
