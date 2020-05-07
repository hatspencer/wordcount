package word.match.impl;

import java.util.ArrayList;
import java.util.List;

import word.match.WordMatcher;

public class ExcludeStopWordMatcherImpl implements WordMatcher {

    private final List<String> stopWords;

    public ExcludeStopWordMatcherImpl(List<String> stopWords) {
        this.stopWords = stopWords == null ? new ArrayList<>() : stopWords;
    }

    @Override
    public boolean match(String word) {
        if (word == null) {
            return false;
        }

        String trimmedWord = word.trim();
        return !stopWords.contains(trimmedWord);
    }
}
