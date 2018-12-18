package com.erstegroup.hiring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopWordsProvider {

    private static final String STOP_FILE = "stopwords.txt";

    public static List<String> readStopWords() throws IOException {
        List<String> stopWords = new ArrayList<String>();
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(STOP_FILE));

        String line = fileBufferedReader.readLine();

        while(line != null) {
            stopWords.add(line);
            line = fileBufferedReader.readLine();
        }

        return stopWords;
    }
}
