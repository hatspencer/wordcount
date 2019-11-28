import java.util.Scanner;
import java.util.stream.StreamSupport;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        String inputText = scanner.nextLine();

        long wordCount = countWords(inputText);

        System.out.println("Number of words: " + wordCount);
    }

    static long countWords(String inputString) {
        String trimmed = inputString.trim();

        if ("".equals(trimmed)) {
            return 0;
        }

        return trimmed.split("\\s+").length;
    }
}
