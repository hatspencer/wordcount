package service.impl;

import model.Output;
import service.WordCounter;

import java.util.HashSet;
import java.util.List;

/**
 * Class for word counting related computation.
 * Assertion: whitespaces are "\\s+" and fullstops should be viewed as whitespaces;
 */
public class WordCounterImpl implements WordCounter {

    private static final String WHITESPACE_REGEX = "[\\s\\.]+";
    private static final String ALLOWED_WORD_CHARSET_REGEX = "[a-zA-Z\\-]+";
    private final List<String> stopWords;
    private final boolean indexActive;

    /**
     * Constructor for word counter
     *
     * @param stopWords stopwords to use for exclusion in counting
     * @param indexActive whether index for unique words should be printed out
     */
    public WordCounterImpl(final List<String> stopWords, final boolean indexActive) {
        this.stopWords = stopWords;
        this.indexActive = indexActive;
    }

    @Override
    public Output processInput(String input) {
        Output result = new Output();

        HashSet<String> uniqueWords = new HashSet<>();
        double sumOfWordLength = 0;

        String[] arr = input.split(WHITESPACE_REGEX);
        int wordCount = arr.length;
        for (String word : arr) {
            if (!word.matches(ALLOWED_WORD_CHARSET_REGEX) || stopWords.contains(word)) {
                wordCount--;
            } else {
                uniqueWords.add(word);
                sumOfWordLength += word.length();
            }
        }
        result.setWordCount(wordCount);
        result.setUniqueWordCount(uniqueWords.size());
        if (uniqueWords.size() != 0) {
            result.setAvgWordLength(sumOfWordLength / wordCount);
        } else {
            result.setAvgWordLength(0);
        }
        result.setIndex(uniqueWords);
        return result;
    }
}
