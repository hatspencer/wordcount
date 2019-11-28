import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    private static final String STOPWORDS_RESOURCE = "stopwords.txt";

    private final Set<String> stopWords;
    private final List<String> inputWords;

    WordCount(Set<String> stopWords, List<String> inputWords) {
        this.stopWords = stopWords;
        this.inputWords = inputWords;
    }

    long getWordCount() {
        return inputWords.stream()
            .filter(word -> !stopWords.contains(word))
            .count();
    }

    public static void main(String[] args) {
        Set<String> stopWords = new StopWordsReader(STOPWORDS_RESOURCE).getStopWords();
        List<String> inputWords;

        try {
            String inputText = new InputTextReader().readInput();
            inputWords = new InputTextParser().parse(inputText);
        } catch (NoSuchElementException e) {
            System.out.println("No correct input");

            return;
        }

        System.out.println("Number of words: " + new WordCount(stopWords, inputWords).getWordCount());
    }
}