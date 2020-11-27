package com.dan.words.reader;

import com.dan.stopwords.StopWords;
import com.dan.words.matcher.WordMatcher;

import java.util.function.Predicate;

class WordFilter {

    private static final WordMatcher WORD_MATCHER = WordMatcher.forPattern("[a-zA-Z]+\\.?");

    private WordFilter() {
        // prevent init
    }

    public static Predicate<String> isValidWord(StopWords stopWords) {
        return (word -> WORD_MATCHER.isValid(word) && !stopWords.contains(word));
    }

}
