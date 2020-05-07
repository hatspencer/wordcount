package word.filter.impl;

import java.util.ArrayList;
import java.util.List;

import word.filter.WordFilter;

public class ExcludedWordFilterImpl implements WordFilter {

    private final List<String> excludedWords;

    public ExcludedWordFilterImpl(List<String> excludedWords) {
        this.excludedWords = excludedWords == null ? new ArrayList<>() : excludedWords;
    }

    @Override
    public boolean filter(String word) {
        if (word == null) {
            return false;
        }

        String trimmedWord = word.trim();
        return !excludedWords.contains(trimmedWord);
    }
}
