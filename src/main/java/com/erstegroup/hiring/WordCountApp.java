package com.erstegroup.hiring;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class WordCountApp {

    public static void main(String [] args) throws IOException {
        String text;

        if (args.length >= 1) {
            text = readInputFromFile(args[0]);
        } else {
            text = readInputFromConsole();
        }

        if (InputValidator.validate(text)) {
            List<String> stopWords = new StopWordsProvider().readStopWords();
            System.out.println("Number of words: " + WordCount.wordCount(text, stopWords));
        } else {
            System.err.println("Error input");
        }
    }

    private static String readInputFromConsole() throws IOException {
        BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter text: ");
        return inputBufferedReader.readLine();
    }

    private static String readInputFromFile(String fileName) throws IOException {
        BufferedReader fileBufferedReader = new BufferedReader(new FileReader(fileName));
        return fileBufferedReader.lines().collect(Collectors.joining(" "));
    }
}
