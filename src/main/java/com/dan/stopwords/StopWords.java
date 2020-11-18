package com.dan.stopwords;

import java.io.IOException;
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
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static StopWords fromWords(String... stopWords) {
        HashSet<String> set = new HashSet<>();

        for (String stopWord : stopWords) {
            if (stopWord != null && !stopWord.isEmpty()) set.add(stopWord);
        }

        return new StopWords(Collections.unmodifiableSet(set));
    }

}
