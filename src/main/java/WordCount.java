import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class WordCount {

    static class CountingResult {
        private long wordsCount;
        private long uniqueWordsCount;

        public CountingResult(long wordsCount, long uniqueWordsCount) {
            this.wordsCount = wordsCount;
            this.uniqueWordsCount = uniqueWordsCount;
        }

        public long getWordsCount() {
            return wordsCount;
        }

        public long getUniqueWordsCount() {
            return uniqueWordsCount;
        }
    }

    private final String userInput;
    private final Set<String> stopWords;

    public WordCount(String userInput, Set<String> stopWords) {
        this.userInput = userInput;
        this.stopWords = stopWords;
    }

    public CountingResult count() {
        List<String> inputWords = new InputTextParser().findWords(userInput);
        List<String> withoutStopWords = new StopWordsFilter(stopWords).filter(inputWords);

        long wordsCount = withoutStopWords.size();
        long uniqueWordsCount = new HashSet<>(withoutStopWords).size();

        return new CountingResult(wordsCount, uniqueWordsCount);
    }
}
