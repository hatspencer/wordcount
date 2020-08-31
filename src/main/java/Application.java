import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Application {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        WordCounter wc = new WordCounter();

        try {
            System.out.println("Enter Text: ");
            System.out.println("Number of words: " + wc.countValidWords(reader.readLine()));

        } catch (IOException e) {
            System.out.println("Could not process request, please try again");
        }
    }
}
