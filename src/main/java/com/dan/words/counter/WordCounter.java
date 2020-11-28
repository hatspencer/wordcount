package com.dan.words.counter;

import java.util.Collection;

public interface WordCounter {

    Collection<String> getWords();

    default int countWords() {
        return getWords().size();
    }

}
