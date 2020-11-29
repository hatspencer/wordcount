package com.dan.words.counter;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface WordCounter {

    Stream<String> getWordStream();

    default Collection<String> getWords() {
        return getWordStream().collect(Collectors.toList());
    }

    default int countWords() {
        return (int) getWordStream().count();
    }

}
