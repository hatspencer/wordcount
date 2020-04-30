import wordreader.FileWordReader;
import wordreader.WordReader;

public class WordCounterApp {

    public static final String STOP_WORDS_FILENAME = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {

        IsWordReaderFactory wordReaderFactory = new WordReaderFactory();

        final WordReader wordReader = wordReaderFactory.getReader(args);

        WordReader stopWordReader = new FileWordReader(STOP_WORDS_FILENAME);
        WordCounter wordCounter = new WordCounter(stopWordReader);

        System.out.println("Number of words: " + wordCounter.countWords(wordReader.readWords()));

    }

}
