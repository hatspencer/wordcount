import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String inputText = args.length == 0 ? readInputFromStdIn() : readInputFromFile(args[0]);

        StopWordReader stopWordReader = new StopWordReader();
        List<String> stopWords = stopWordReader.readStopWords();
        WordCounter wordCounter = new WordCounter(stopWords);
        WordCounter.WordCountStatistics wordCountStatistics = wordCounter.countWords(inputText);

        String output = String.format("Number of words: %d, unique: %d", wordCountStatistics.totalCount, wordCountStatistics.uniqueCount);
        System.out.println(output);
    }

    private static String readInputFromStdIn() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text:");
        return in.nextLine();
    }

    private static String readInputFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
