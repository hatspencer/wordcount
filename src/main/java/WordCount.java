import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");

        try {
            String inputText = scanner.nextLine();
            long wordCount = countWords(inputText);
            System.out.println("Number of words: " + wordCount);
        } catch (NoSuchElementException e) {
            System.out.println("No correct input");
        }
    }

    static long countWords(String inputString) {
        String trimmed = inputString.trim();

        if ("".equals(trimmed)) {
            return 0;
        }

        return Arrays.stream(trimmed.split("\\s+"))
            .filter(token -> token.matches("[a-zA-Z]+"))
            .count();
    }
}
