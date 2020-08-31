import java.io.IOException;
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
        int wordCount = wordCounter.countWords(inputText);

        System.out.println("Number of words: " + wordCount);
    }

    private static String readInputFromStdIn() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text:");
        return in.nextLine();
    }

    private static String readInputFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
