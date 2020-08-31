import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {

        WordCounter wc = new WordCounter();

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        List<String> stopWords = FileHelper.readAllLines("stopwords.txt");

        String userInput = "";
        if (args.length > 0 && args[0] != null) {
            List<String> fileContent = FileHelper.readAllLines(args[0]);
            System.out.println("number of words: "  + wc.countValidWords(String.join(" ", fileContent), stopWords) + " unique: " + wc.countUniqueWords(String.join(" ", fileContent), stopWords));
            System.out.println("average number of words: "  + wc.calculateTheAverage(String.join(" ", fileContent), stopWords));
        } else {
           userInput = reader.readLine();
           System.out.println("number of words: "  + wc.countValidWords(userInput, stopWords) + " unique: " + wc.countUniqueWords(userInput, stopWords));
           System.out.println("average number of words: "  + wc.calculateTheAverage(userInput, stopWords));
        }
    }
}
