package word.filter.impl;

import java.util.HashSet;
import java.util.Set;

import word.filter.WordFilter;

public class UniqueWordFilterImpl implements WordFilter {

    private final Set<String> uniqueWords = new HashSet<>();

    @Override
    public boolean filter(String word) {
        boolean isWordUnique = uniqueWords.contains(word);
        uniqueWords.add(word);
        return isWordUnique;
    }
}
