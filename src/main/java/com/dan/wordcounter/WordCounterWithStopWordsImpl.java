package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import com.dan.words.WordMatcher;

public class WordCounterWithStopWordsImpl implements WordCounter {

    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    private StopWords stopWords;

    public WordCounterWithStopWordsImpl() {
        this(StopWords.fromFile(STOPWORDS_FILE_PATH));
    }

    WordCounterWithStopWordsImpl(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        final String[] parts = input.split("[\\s-]");

        final WordMatcher wordMatcher = WordMatcher.forPattern("[a-zA-Z]+\\.?");

        int wordCount = 0;
        for (String part : parts) {
            if (wordMatcher.isValid(part)) {
                part = part.replaceFirst("\\.", "");

                if (!stopWords.contains(part)) {
                    wordCount++;
                }
            }
        }

        return wordCount;
    }

}
