package com.dan.words.matcher;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordMatcher {

    private Pattern pattern;

    WordMatcher(String pattern) {
        this.pattern = Pattern.compile(pattern);
    }

    public boolean isValid(String word) {
        Matcher matcher = pattern.matcher(word);
        return matcher.matches();
    }

    public static WordMatcher forPattern(String pattern) {
        return new WordMatcher(pattern);
    }

}
