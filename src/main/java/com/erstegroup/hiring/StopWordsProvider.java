package com.erstegroup.hiring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopWordsProvider {

    private static final String STOP_FILE = "C:\\Erste\\wordcount\\src\\main\\Resources\\stopwords.txt";

    public static List<String> readStopWords() throws IOException {
        return readStopWords(STOP_FILE);
    }

    public static List<String> readStopWords(String fileName) throws IOException {
        List<String> stopWords = new ArrayList<>();
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(fileName));

        String line = fileBufferedReader.readLine();

        while(line != null) {
            stopWords.add(line);
            line = fileBufferedReader.readLine();
        }

        return stopWords;
    }
}
