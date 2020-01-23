import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCount {

    public static void main(String[] args) {
        int wordCount = 0;
        System.out.print("Enter text:");
        Scanner userInput = new Scanner(System.in);
        String inputString = userInput.nextLine();

        List<String> potentialWords = Arrays.asList(inputString.split("\\s"));

        for (String word : potentialWords) {
            if (!word.isEmpty()) {
                wordCount++;
            }
        }

        System.out.println("Number of words: " + wordCount);
    }
}
