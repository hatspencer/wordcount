package com.dan.words.counter;

import com.dan.dictionary.Dictionary;

import java.util.Collection;
import java.util.stream.Collectors;

public class UnknownWordCounterImpl implements WordCounter {

    private Dictionary index;
    private Dictionary knownWords;

    public UnknownWordCounterImpl(Dictionary index, Dictionary knownWords) {
        this.index = index;
        this.knownWords = knownWords;
    }

    @Override
    public Collection<String> getWords() {
        return index.stream()
                .filter(word -> !knownWords.contains(word))
                .collect(Collectors.toList());
    }

}
