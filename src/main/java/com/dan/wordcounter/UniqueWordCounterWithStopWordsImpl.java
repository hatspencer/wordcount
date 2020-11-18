package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import com.dan.words.WordMatcher;

import java.util.Arrays;
import java.util.stream.Stream;

public class UniqueWordCounterWithStopWordsImpl implements WordCounter {

    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    private StopWords stopWords;
    private WordMatcher wordMatcher;

    public UniqueWordCounterWithStopWordsImpl() {
        this(StopWords.fromFile(STOPWORDS_FILE_PATH));
    }

    UniqueWordCounterWithStopWordsImpl(StopWords stopWords) {
        this.stopWords = stopWords;
        this.wordMatcher = WordMatcher.forPattern("[a-zA-Z]+\\.?");
    }

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        return (int) filterWords(input).distinct().count();
    }

    private Stream<String> filterWords(String input) {
        return Arrays.stream(input.split("[\\s-]"))
                .map(part -> part.replaceFirst("\\.", ""))
                .filter(part -> wordMatcher.isValid(part) && !stopWords.contains(part));
    }

}
