package service.impl;

import model.Output;
import service.WordCounterService;

import java.util.HashSet;
import java.util.List;

/**
 * Class for word counting.
 * Assertion: whitespaces are "\\s+" and fullstops should be viewed as whitespaces;
 */
public class WordCounterImpl implements WordCounterService {

    private static final String WHITESPACE_REGEX = "[\\s\\.]+";
    private static final String ALLOWED_WORD_CHARSET_REGEX = "[a-zA-Z\\-]+";
    private final List<String> stopWords;

    /**
     * Constructor for word counter
     *
     * @param stopWords stopwords to use for exclusion in counting
     */
    public WordCounterImpl(final List<String> stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public Output processInput(String input) {
        Output result = new Output();

        HashSet<String> uniqueWords = new HashSet<>();
        String[] arr = input.split(WHITESPACE_REGEX);
        int wordCount = arr.length;
        for (String word : arr) {
            if (!word.matches(ALLOWED_WORD_CHARSET_REGEX) || stopWords.contains(word)) {
                wordCount--;
            } else {
                uniqueWords.add(word);
            }
        }
        result.setWordCount(wordCount);
        result.setUniqueWordCount(uniqueWords.size());
        return result;
    }
}
