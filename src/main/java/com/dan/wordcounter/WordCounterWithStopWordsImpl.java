package com.dan.wordcounter;

import com.dan.stopwords.StopWords;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterWithStopWordsImpl implements WordCounter {

    private static final String STOPWORDS_FILE_PATH = "src/main/resources/stopwords.txt";

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

        final String[] parts = input.split("\\s");
        final Pattern pattern = Pattern.compile("[a-zA-Z]+");

        int wordCount = 0;
        for (String part : parts) {
            Matcher matcher = pattern.matcher(part);

            if (matcher.matches() && !stopWords.contains(part)) wordCount++;
        }

        return wordCount;
    }

}
