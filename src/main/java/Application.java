import wordcount.WordCounter;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final String PROMPT = "Enter text: ";
    private static final String OUTPUT_PREFIX = "Number of words: ";

    public static void main(String[] args) {
        System.out.print(PROMPT);
        Scanner userInput = new Scanner(System.in);
        String inputString = userInput.nextLine();
        List<String> stopwords = getStopwords();
        int wordCount = new WordCounter(stopwords).countWordsInUserInput(inputString);
        System.out.println(OUTPUT_PREFIX.concat(String.valueOf(wordCount)));
    }

    private static List<String> getStopwords() {
        //TODO - Read stopwords from file.
        return Collections.emptyList();
    }

}
