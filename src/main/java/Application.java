import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        WordCounter wc = new WordCounter();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> stopWords = Files.readAllLines(Paths.get("stopwords.txt"), StandardCharsets.UTF_8);

        try {
            System.out.println("Enter Text: ");
            // System.out.println("Number of words: " + wc.countValidWords(reader.readLine()));
            System.out.println("Number of words (when processed against stop words): " + wc.countValidWords(reader.readLine(), stopWords));
        } catch (IOException e) {
            System.out.println("Could not process request, please try again");
        }
    }
}
