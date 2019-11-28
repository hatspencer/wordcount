import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    public static void main(String[] args) {
        Set<String> stopwords = new StopWordsReader("stopwords.txt").getStopWords();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        try {
            String inputText = scanner.nextLine();

            long wordCount = new InputTextParser().parse(inputText).stream()
                .filter(word -> !stopwords.contains(word))
                .count();

            System.out.println("Number of words: " + wordCount);
        } catch (NoSuchElementException e) {
            System.out.println("No correct input");
        }
    }
}