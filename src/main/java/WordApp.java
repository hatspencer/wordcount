import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class WordApp {

    private static WordsCounter wordsCounter = new WordsCounter();

    public static void main(String... args) {
        List<String> stopWordLines;
        try {
            stopWordLines = Files.readAllLines(new File("stopWords.txt").toPath());
            System.out.println("Enter text:");
            Scanner userInputScanner = new Scanner(System.in);
            String inputString = userInputScanner.nextLine();
            System.out.println("Number of words: " + wordsCounter.countWords(inputString, stopWordLines));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
