package solver;

import model.Output;

import java.util.HashSet;
import java.util.List;

/**
 * Class for word counting.
 * Assertion: whitespaces are "\\s+";
 */
public class WordCounter {

    private static final String WHITESPACE_REGEX = "[\\s\\-\\.]+";
    private static final String ALLOWED_WORD_CHARSET_REGEX = "[a-zA-Z]+";
    private final List<String> stopWords;
    private HashSet<String> words = new HashSet<>();

    /**
     * Constructor for word counter
     *
     * @param stopWords stopwords to use for exclusion in counting
     */
    public WordCounter(final List<String> stopWords) {
        this.stopWords = stopWords;
    }

    /**
     * Counts the words in a text (words are characters enclosed by whitespaces)
     * Stopwords are excluded in the counting
     *
     * @param input the input text to count words for
     * @return the number of words.
     */
    public Output solve(String input) {
        Output result = new Output();
        String[] arr = input.split(WHITESPACE_REGEX);
        int wordCount = arr.length;
        for (String word : arr) {
            if (!word.matches(ALLOWED_WORD_CHARSET_REGEX) || stopWords.contains(word)) {
                wordCount--;
            } else {
                words.add(word);
            }
        }
        result.setWordCount(wordCount);
        result.setUniqueWordCount(words.size());
        return result;
    }
}
