package com.dan.words.index;

import com.dan.dictionary.Dictionary;
import com.dan.dictionary.DictionaryBuilder;
import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;
import com.dan.words.reader.WordReaderImpl;

import java.util.List;
import java.util.stream.Collectors;

public class WordIndexCreatorImpl implements WordIndexCreator {

    private String input;
    private WordReader wordReader;

    public WordIndexCreatorImpl(String input) {
        this(input, StopWords.fromFile());
    }

    WordIndexCreatorImpl(String input, StopWords stopWords) {
        this.input = input;
        this.wordReader = new WordReaderImpl(stopWords);
    }

    @Override
    public Dictionary createIndex() {
        List<String> index = wordReader.readWords(input)
                .distinct()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());

        return DictionaryBuilder.fromCollection(index);
    }

}
