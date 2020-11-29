package com.dan.words.counter;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;
import com.dan.words.reader.WordReaderImpl;

import java.util.stream.Stream;

public class UniqueWordCounterImpl implements WordCounter {

    private String input;
    private WordReader wordReader;

    public UniqueWordCounterImpl(String input) {
        this(input, StopWords.fromFile());
    }

    UniqueWordCounterImpl(String input, StopWords stopWords) {
        this.input = input;
        this.wordReader = new WordReaderImpl(stopWords);
    }

    @Override
    public Stream<String> getWordStream() {
        return wordReader.readWords(input).distinct();
    }

}
