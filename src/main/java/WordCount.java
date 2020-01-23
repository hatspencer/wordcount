import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCount {

    private static final String PROMPT = "Enter text: ";
    private static final String OUTPUT_PREFIX = "Number of words: ";
    private static int wordCount = 0;

    public static void main(String[] args) {
        System.out.print(PROMPT);
        Scanner userInput = new Scanner(System.in);
        String inputString = userInput.nextLine();
        String[] potentialWords = inputString.split("\\s");

        for (String word : potentialWords) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        System.out.println(OUTPUT_PREFIX.concat(String.valueOf(wordCount)));
    }
}
