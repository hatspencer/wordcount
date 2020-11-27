package com.dan.words.counter;

import com.dan.stopwords.StopWords;
import com.dan.words.reader.WordReader;

public class UniqueWordCounterImpl implements WordCounter {

    private StopWords stopWords;

    public UniqueWordCounterImpl() {
        this(StopWords.fromFile());
    }

    UniqueWordCounterImpl(StopWords stopWords) {
        this.stopWords = stopWords;
    }

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        Long count = WordReader.readWords(input, stopWords)
                .distinct()
                .count();

        return count.intValue();
    }

}
