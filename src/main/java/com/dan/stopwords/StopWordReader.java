package com.dan.stopwords;

import com.dan.util.FileReader;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StopWordReader {

    private StopWordReader() {
        //prevent init
    }

    public static Set<String> readStopWords(String filePath) {
        if (filePath == null) {
            throw new IllegalArgumentException("The stopwords file path cannot be null!");
        }

        Set<String> stopWords = new HashSet<>();

        List<String> lines = FileReader.readLinesFromClassPath(filePath);

        for (String stopWord : lines) {
            if (!stopWord.isEmpty()) {
                stopWords.add(stopWord);
            }
        }

        return stopWords;
    }

}
