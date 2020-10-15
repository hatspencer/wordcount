package solver;

/**
 * Class for word counting.
 * Assertion: whitespaces are "\\s+";
 */
public class WordCounter {

    private static final String WHITESPACE_REGEX = "\\s+";
    private static final String ALLOWED_WORD_CHARSET_REGEX = "[a-zA-Z]+";

    /**
     * Counts the words in a text (words are characters enclosed by whitespaces)
     * @param text the input text to count words for
     * @return the number of words.
     */
    public int countWords(String text) {
        String[] arr = text.split(WHITESPACE_REGEX);
        int wordCount = arr.length;
        for (String word: arr) {
            if (!word.matches(ALLOWED_WORD_CHARSET_REGEX)) {
                wordCount--;
            }
        }
        return wordCount;
    }
}
