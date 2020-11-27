package com.dan.stopwords;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StopWords {

    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

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

    public static StopWords fromFile() {
        Set<String> stopWords = StopWordReader.readStopWords(STOPWORDS_FILE_PATH);
        return new StopWords(Collections.unmodifiableSet(stopWords));
    }

    public static StopWords fromWords(String... stopWords) {
        HashSet<String> set = new HashSet<>();

        for (String stopWord : stopWords) {
            if (stopWord != null && !stopWord.isEmpty()) set.add(stopWord);
        }

        return new StopWords(Collections.unmodifiableSet(set));
    }

}
