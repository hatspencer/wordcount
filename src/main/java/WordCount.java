import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCount {

    private static final String PROMPT = "Enter text: ";
    private static final String OUTPUT_PREFIX = "Number of words: ";
    private static int wordCount = 0;
    private static String inputString;

    public static void main(String[] args) {
        System.out.print(PROMPT);
        Scanner userInput = new Scanner(System.in);
        inputString = userInput.nextLine();
        countWordsInUserInput(inputString);
        System.out.println(OUTPUT_PREFIX.concat(String.valueOf(wordCount)));
    }

    static int countWordsInUserInput(String userInput) {
        String[] potentialWords = userInput.split("(\\s)");
        for (String word : potentialWords) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }
        return wordCount;
    }
}
