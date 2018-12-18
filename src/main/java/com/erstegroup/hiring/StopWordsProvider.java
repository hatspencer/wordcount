package com.erstegroup.hiring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopWordsProvider {

    public List<String> readStopWords() throws IOException {
        ClassLoader classLoader = getClass().getClassLoader();
        return readStopWords(classLoader.getResource("stopwords.txt").getFile());
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

    public  File readFile(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(classLoader.getResource(fileName).getFile());
    }
}
