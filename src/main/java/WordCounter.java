import wordreader.WordReader;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private final Set<String> stopWords;

    public WordCounter(WordReader stopWordReader) {

        this.stopWords = new HashSet<>(stopWordReader.readWords());

    }

    public long countUniqueWords(Collection<String> words) {
            return countWords(words, true);
    }

    public long countWords(Collection<String> words) {
        return countWords(words, false);
    }

    /**
     *
     * @param words
     * @param unique true to count only unique words, false otherwise
     * @return
     */
    private long countWords(Collection<String> words, boolean unique) {

        if (words == null) {
            return 0;
        }

        Stream<String> wordsStream = words.stream()
                .map(word -> word.trim())
                .filter(WordCounter::isWord)
                .filter(this::isNotStopWord);

        if (unique) {
            List<String> allWords = wordsStream.collect(Collectors.toList());
            Set<String> uniqueWords = new HashSet<>();
            uniqueWords.addAll(allWords);

            return uniqueWords.size();
        } else {

            return wordsStream.count();
        }
    }

    public static boolean isWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }

        String trimmedWord = word.trim();

//        trimmedWord = trimmedWord.replace(".", "");
//        trimmedWord = trimmedWord.replace("-", "");
//        trimmedWord = trimmedWord.replace(",", ""); //TODO other characters to ignore

        return trimmedWord.replaceAll("[a-zA-Z]", "").length() == 0;
    }

    public boolean isNotStopWord(String word) {
        if (stopWords == null || word == null) {
            return true;
        }
        return !stopWords.contains(word);
    }

}
