import java.util.Arrays;

public class WordCounter {

    private final StopWordReader stopWordReader;

    private final String WORD_PATTERN = "[A-Za-z]+";

    public WordCounter(StopWordReader stopWordReader) {
        this.stopWordReader = stopWordReader;
    }

    public String[] splitTextAtWhitespace(String text) {
        return text.split(" ");
    }

    public long countWords(String[] words) {
        return Arrays.stream(words)
                .filter(word -> word.matches("[A-Za-z]+"))
                .filter(word -> !stopWordReader.readStopWords().contains(word))
                .count();
    }

    public long countUniqueWords(String[] words) {
        return Arrays.stream(words)
                .filter(word -> word.matches("[A-Za-z]+"))
                .filter(word -> !stopWordReader.readStopWords().contains(word))
                .distinct()
                .count();
    }

}