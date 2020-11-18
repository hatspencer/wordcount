package com.dan.wordcounter.streamoperation;

import com.dan.stopwords.StopWords;
import com.dan.words.WordMatcher;

import java.util.function.Predicate;

public class WordFilter {

    private WordFilter() {
        // prevent init
    }

    public static Predicate<String> isValidWord(WordMatcher wordMatcher, StopWords stopWords) {
        return (part -> wordMatcher.isValid(part) && !stopWords.contains(part));
    }

}
