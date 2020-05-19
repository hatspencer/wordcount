import java.util.List;

public class WordCountResult {

    private final List<DictionaryWord> indexedWords;
    private final int numberOfWords;
    private final int numberOfUniqueWords;
    private final double averageWordLength;

    public WordCountResult(List<DictionaryWord> indexedWords, int numberOfWords, int numberOfUniqueWords, double averageWordLength) {
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

    public List<DictionaryWord> getIndexedWords() {
        return indexedWords;
    }

    public int getNumberOfUnknownWords() {
        return (int) indexedWords
                .stream()
                .filter(word -> !word.isMatched())
                .count();
    }
}
