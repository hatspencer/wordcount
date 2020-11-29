package com.dan.words.counter;

import com.dan.dictionary.Dictionary;

import java.util.stream.Stream;

public class UnknownWordCounterImpl implements WordCounter {

    private Dictionary index;
    private Dictionary knownWords;

    public UnknownWordCounterImpl(Dictionary index, Dictionary knownWords) {
        this.index = index;
        this.knownWords = knownWords;
    }

    @Override
    public Stream<String> getWordStream() {
        return index.stream().filter(word -> !knownWords.contains(word));
    }

}
