package com.dan.words.counter;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;

import java.util.Collection;
import java.util.stream.Collectors;

public class WordCounterImpl implements WordCounter {

    private String input;
    private StopWords stopWords;

    public WordCounterImpl(String input) {
        this(input, StopWords.fromFile());
    }

    WordCounterImpl(String input, StopWords stopWords) {
        this.input = input;
        this.stopWords = stopWords;
    }

    @Override
    public Collection<String> getWords() {
        return WordReader.readWords(input, stopWords)
                .collect(Collectors.toList());
    }

}
