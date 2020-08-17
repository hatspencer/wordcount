import java.util.List;

public class WordApp {

    private static WordsCounter wordsCounter = new WordsCounter();
    private static DataInputHelper dataInputHelper = new DataInputHelper();

    public static void main(String... args) {
        List<String> stopWordLines = dataInputHelper.readFile();
        String userInput = dataInputHelper.readUserInput();
        System.out.println("Number of words: " + wordsCounter.countWords(userInput, stopWordLines));
    }
}
