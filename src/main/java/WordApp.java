import java.util.List;

public class WordApp {

    private static WordsCounter wordsCounter = new WordsCounter();
    private static DataInputHelper dataInputHelper = new DataInputHelper();

    public static void main(String... args) {
        String filename = null;
        if (args.length > 0) {
            filename = args[0];
        }
        List<String> stopWordLines = dataInputHelper.readStopWordsFile();
        String wordsToCount = dataInputHelper.readWordsToCount(filename);
        System.out.println("Number of words: " + wordsCounter.countWords(wordsToCount, stopWordLines));
    }

    private static boolean isFilenameProvided(String... args) {
        return args.length > 0;
    }
}
