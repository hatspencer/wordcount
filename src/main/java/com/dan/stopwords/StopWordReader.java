package com.dan.stopwords;

import com.dan.io.FileReader;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class StopWordReader {

    private String filePath;

    public StopWordReader(String filePath) {
        this.filePath = filePath;
    }

    public Set<String> readStopWords() throws IOException {
        Set<String> stopWords = new HashSet<>();

        List<String> lines = FileReader.readLines(this.filePath);

        for (String stopWord : lines) {
            if (!stopWord.isEmpty()) {
                stopWords.add(stopWord);
            }
        }

        return stopWords;
    }

}
