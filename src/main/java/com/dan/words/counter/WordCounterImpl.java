package com.dan.words.counter;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;

public class WordCounterImpl implements WordCounter {

    private StopWords stopWords;

    public WordCounterImpl() {
        this(StopWords.fromFile());
    }

    WordCounterImpl(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        Long count = WordReader.readWords(input, stopWords)
                .count();

        return count.intValue();
    }

}
