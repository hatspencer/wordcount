import io.FileReader;
import wordcount.WordCounter;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Application {

    private static final String PROMPT = "Enter text: ";
    private static final String OUTPUT_PREFIX = "Number of words: ";
    private static final String FILE_NAME = "stopwords.txt";

    public static void main(String[] args) throws IOException {
        System.out.print(PROMPT);
        Scanner userInput = new Scanner(System.in);
        String inputString = userInput.nextLine();
        List<String> stopwords = new FileReader().getStopwords(FILE_NAME);
        int wordCount = new WordCounter(stopwords).countWordsInUserInput(inputString);
        System.out.println(OUTPUT_PREFIX.concat(String.valueOf(wordCount)));
    }
}
