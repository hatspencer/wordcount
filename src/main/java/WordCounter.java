import java.util.Arrays;

public class WordCounter {

    private final StopWordReader stopWordReader;

    private final static String WORD_PATTERN = "[A-Za-z.]+";

    private final static String WORD_DELIMITER = "[ -]";

    public WordCounter(StopWordReader stopWordReader) {
        this.stopWordReader = stopWordReader;
    }

    private String[] splitText(String text) {
        return text.split(WORD_DELIMITER);
    }

    public long countWords(String text) {
        return Arrays.stream(this.splitText(text))
                .filter(word -> word.matches(WORD_PATTERN))
                .filter(word -> !stopWordReader.readStopWords().contains(word))
                .count();
    }

    public long countUniqueWords(String text) {
        return Arrays.stream(this.splitText(text)).filter(word -> word.matches(WORD_PATTERN))
                .filter(word -> !stopWordReader.readStopWords().contains(word))
                .distinct()
                .count();
    }

}