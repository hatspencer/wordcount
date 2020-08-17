import java.util.List;

public class WordApp {

    private static WordsCounter wordsCounter = new WordsCounter();
    private static DataInputHelper dataInputHelper = new DataInputHelper();

    public static void main(String... args) {
        String filename = dataInputHelper.retrieveFilename(args);
        List<String> stopWordLines = dataInputHelper.readStopWordsFile();
        String wordsToCount = dataInputHelper.readWordsToCount(filename);
        ResultModel result = wordsCounter.countWords(wordsToCount, stopWordLines);
        System.out.println("Number of words: " + result.getTotalWordsCount() + "; unique: " + result.getUniqueWordsCount() + "; average word length: " + result.getAvgWordLength());
    }
}
