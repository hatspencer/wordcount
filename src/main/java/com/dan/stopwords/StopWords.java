package com.dan.stopwords;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StopWords {

    private Set<String> stopWords;

    StopWords(Set<String> stopWords) {
        this.stopWords = stopWords;
    }

    public boolean contains(String word) {
        if (word == null) {
            return false;
        }

        return stopWords.contains(word);
    }

    public static StopWords fromFile(String fileName) {
        try {
            Set<String> stopWords = new StopWordReader(fileName).readStopWords();
            return new StopWords(Collections.unmodifiableSet(stopWords));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static StopWords fromWords(String... stopWords) {
        Set<String> stopWordsSet = Collections.unmodifiableSet(new HashSet<>(Arrays.asList(stopWords)));
        return new StopWords(stopWordsSet);
    }

}
