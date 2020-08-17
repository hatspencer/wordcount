import java.util.List;

public class WordApp {

    private static WordsCounter wordsCounter = new WordsCounter();
    private static DataInputHelper dataInputHelper = new DataInputHelper();

    public static void main(String... args) {
        String filename = dataInputHelper.retrieveFilename(args);
        List<String> stopWordLines = dataInputHelper.readStopWordsFile();
        String wordsToCount = dataInputHelper.readWordsToCount(filename);
        System.out.println("Number of words: " + wordsCounter.countWords(wordsToCount, stopWordLines));
    }
}
