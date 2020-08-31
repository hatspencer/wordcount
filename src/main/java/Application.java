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

        List<String> stopWords = FileHelper.readAllLines("stopwords.txt");

        long numWords;
        if (args.length > 0 && args[0] != null) {
            List<String> fileContent = FileHelper.readAllLines(args[0]);
            numWords = wc.countValidWords(String.join(" ", fileContent), stopWords);
        } else {
           // numWords = wc.countValidWords(reader.readLine(), stopWords);
            numWords = wc.countValidWords("Humpty Dumpty sat wall Humpty Dumpty had great fall"
                    , stopWords);
        }
        System.out.println("number words are: "  + numWords);
    }
}
