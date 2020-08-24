import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WordCountMain {

    public static void main(String[] args) throws IOException {
        System.out.print("Enter text: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        System.out.printf("Number of words %d%n", wordCount(line));
    }

    static int wordCount(String line) {
        String[] parts = line.split(" ");
        int count = 0;
        for (String part : parts) {
            if (part.matches("[a-zA-Z]+")) {
                count++;
            }
        }
        return count;
    }
}
