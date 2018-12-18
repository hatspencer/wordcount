package com.erstegroup.hiring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class WordCountApp {

    public static void main(String [] args) throws IOException {
        BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text: ");
        String text = inputBufferedReader.readLine();
        if (InputValidator.validate(text)) {
            List<String> stopWords = StopWordsProvider.readStopWords();
            System.out.println("Number of words: " + WordCount.wordCount(text, stopWords));
        } else {
            System.err.println("Error input");
        }
    }
}
