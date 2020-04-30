import wordreader.WordReader;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class WordCounter {

    private final Set<String> stopWords;

    public WordCounter(WordReader stopWordReader) {

        this.stopWords = new HashSet<>(stopWordReader.readWords());

    }

    public long countWords(Collection<String> words) {

        if (words == null) {
            return 0;
        }

        long numWords = words.stream()
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
