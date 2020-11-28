package com.dan.dictionary;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class Dictionary {

    private Collection<String> words;
    private boolean isCaseSensitive;

    Dictionary(Collection<String> words, boolean isCaseSensitive) {
        this.words = words;
        this.isCaseSensitive = isCaseSensitive;
    }

    public Collection<String> getWords() {
        return words;
    }

    public Stream<String> stream() {
        return words.stream();
    }

    public int size() {
        return words.size();
    }

    public String get(int index) {
        if (!(words instanceof List)) {
            throw new UnsupportedOperationException();
        }

        return ((List<String>) words).get(index);
    }

    public boolean contains(String word) {
        if (word == null) {
            return false;
        }

        if (!isCaseSensitive) word = word.toLowerCase();

        return words.contains(word);
    }

}
