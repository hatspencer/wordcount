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

        if(args[0] != null) {
            List<String> fileContent = FileHelper.readAllLines(args[0]);
            System.out.println("file content as string" +  String.join(" ", fileContent));
            wc.countValidWords(String.join(" ", fileContent), stopWords);
            System.out.println("number words are "  + wc.countValidWords(String.join(" ", fileContent), stopWords));
        }

    }
}
