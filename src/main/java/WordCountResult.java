import java.util.List;

public class WordCountResult {

    private final List<String> indexedWords;
    private final int numberOfWords;
    private final int numberOfUniqueWords;
    private final double averageWordLength;

    public WordCountResult(List<String> indexedWords, int numberOfWords, int numberOfUniqueWords, double averageWordLength) {
        this.indexedWords = indexedWords;
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
        this.averageWordLength = averageWordLength;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }

    public double getAverageWordLength() {
        return averageWordLength;
    }

    public List<String> getIndexedWords() {
        return indexedWords;
    }
}
