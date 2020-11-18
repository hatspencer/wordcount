package com.dan.stopwords;

import com.dan.util.FileReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StopWordReader {

    private StopWordReader() {
        //prevent init
    }

    public static Set<String> readStopWords(String filePath) throws IOException {
        if (filePath == null) {
            throw new IllegalArgumentException("The stopwords file path cannot be null!");
        }

        Set<String> stopWords = new HashSet<>();

        List<String> lines = FileReader.readLines(filePath);

        for (String stopWord : lines) {
            if (!stopWord.isEmpty()) {
                stopWords.add(stopWord);
            }
        }

        return stopWords;
    }

}
