package com.erstegroup.hiring;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StopWordsProvider {

    private static final FileFactory FILE_FACTORY = new FileFactory();

    public static List<String> readStopWords() throws IOException {
        File file = FILE_FACTORY.getFileFrom("stopwords.txt");
        return readStopWords(file.getPath());
    }

    public static List<String> readStopWords(String filePath) throws IOException {
        List<String> stopWords = new ArrayList<>();
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(filePath));

        String line = fileBufferedReader.readLine();

        while(line != null) {
            stopWords.add(line);
            line = fileBufferedReader.readLine();
        }

        return stopWords;
    }
}
