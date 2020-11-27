package com.dan.words.index;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;

import java.util.List;
import java.util.stream.Collectors;

public class WordIndexCreatorImpl implements WordIndexCreator {

    private StopWords stopWords;

    public WordIndexCreatorImpl() {
        this(StopWords.fromFile());
    }

    WordIndexCreatorImpl(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public List<String> createIndex(String input) {
        return WordReader.readWords(input, stopWords)
                .distinct()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
    }
}
