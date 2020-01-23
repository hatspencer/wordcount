import wordcount.WordCounter;

import java.util.Scanner;

public class WordCount {

    private static final String PROMPT = "Enter text: ";
    private static final String OUTPUT_PREFIX = "Number of words: ";

    public static void main(String[] args) {
        System.out.print(PROMPT);
        Scanner userInput = new Scanner(System.in);
        String inputString = userInput.nextLine();
        int wordCount = WordCounter.countWordsInUserInput(inputString);
        System.out.println(OUTPUT_PREFIX.concat(String.valueOf(wordCount)));
    }

}
