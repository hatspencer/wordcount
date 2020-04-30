import java.util.Arrays;
import java.util.Set;

public class WordCounter {

    private final Set<String> stopWords;

    public WordCounter(StopWordReader stopWordReader) {

        this.stopWords = stopWordReader.readStopWords();

    }

    public long countWords(String sentence) {

        if (sentence == null) {
            sentence = "";
        }

        String[] words = sentence.split(" ");

        long numWords = Arrays.stream(words)
                .filter(WordCounter::isWord)
                .filter(this::isNotStopWord)
                .count();

        return numWords;
    }

    public static boolean isWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }
        return word.replaceAll("[a-zA-Z]", "").length() == 0;
    }

    public boolean isNotStopWord(String word) {
        if (stopWords == null || word == null) {
            return true;
        }
        return !stopWords.contains(word);
    }

}
