package com.dan.stopwords;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StopWordReader {

    private String filename;

    public StopWordReader(String filename) {
        this.filename = filename;
    }

    public Set<String> readStopWords() throws FileNotFoundException {
        File file = new File(this.filename);

        Set<String> stopWords = new HashSet<>();

        Scanner sc = null;
        try {
            sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String stopWord = sc.nextLine();
                if (!stopWord.isEmpty()) {
                    stopWords.add(stopWord);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

            throw e;
        } finally {
            if (sc != null) sc.close();
        }

        return stopWords;
    }

}
