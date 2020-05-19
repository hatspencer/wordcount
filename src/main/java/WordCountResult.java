public class WordCountResult {

    private final int numberOfWords;
    private final int numberOfUniqueWords;

    public WordCountResult(int numberOfWords, int numberOfUniqueWords) {
        this.numberOfWords = numberOfWords;
        this.numberOfUniqueWords = numberOfUniqueWords;
    }

    public int getNumberOfWords() {
        return numberOfWords;
    }

    public int getNumberOfUniqueWords() {
        return numberOfUniqueWords;
    }
}
