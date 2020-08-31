import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text:");

        String inputLine = in.nextLine();

        StopWordReader stopWordReader = new StopWordReader();
        List<String> stopWords = stopWordReader.readStopWords();
        WordCounter wordCounter = new WordCounter(stopWords);
        int wordCount = wordCounter.countWords(inputLine);

        System.out.println("Number of words: " + wordCount);

    }
}
