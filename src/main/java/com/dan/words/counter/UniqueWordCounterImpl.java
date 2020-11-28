package com.dan.words.counter;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;

import java.util.Collection;
import java.util.stream.Collectors;

public class UniqueWordCounterImpl implements WordCounter {

    private String input;
    private StopWords stopWords;

    public UniqueWordCounterImpl(String input) {
        this(input, StopWords.fromFile());
    }

    UniqueWordCounterImpl(String input, StopWords stopWords) {
        this.input = input;
        this.stopWords = stopWords;
    }

    @Override
    public Collection<String> getWords() {
        return WordReader.readWords(input, stopWords)
                .distinct()
                .collect(Collectors.toList());
    }

}
