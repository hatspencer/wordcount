package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import com.dan.words.WordMatcher;

import java.util.Arrays;

public class WordCounterWithStopWordsImpl implements WordCounter {

    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    private StopWords stopWords;

    final WordMatcher wordMatcher = WordMatcher.forPattern("[a-zA-Z]+\\.?");

    public WordCounterWithStopWordsImpl() {
        this(StopWords.fromFile(STOPWORDS_FILE_PATH));
    }

    WordCounterWithStopWordsImpl(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        final WordMatcher wordMatcher = WordMatcher.forPattern("[a-zA-Z]+\\.?");

        return (int) Arrays.stream(input.split("[\\s-]"))
                .map(part -> part.replaceFirst("\\.", ""))
                .filter(part -> wordMatcher.isValid(part) && !stopWords.contains(part))
                .count();
    }

}
