package com.erste.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.erste.main.io.FileReader;
import com.erste.main.util.StringUtil;

public class Main {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS = "Number of words: %s";
    private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

    private Scanner scanner;

    public static void main(String[] args) {
        new Main(new Scanner(System.in));
    }

    public Main(Scanner scanner) {
        this.scanner = scanner;
    }

    public int run() {
        System.out.print(ENTER_TEXT);
        int wordCount = filterOutStopWords(scanner.nextLine()).size();
        System.out.println(String.format(NUMBER_OF_WORDS, wordCount));

        return wordCount;
    }

    private List<String> filterOutStopWords(String input) {
        List<String> filteredWords = new ArrayList<>();
        List<String> stopWords = FileReader.readFileAsLines(STOPWORDS_FILE_NAME);

        String[] splitString = input.split("\\s");

        for (String word : splitString) {
            if (StringUtil.isAlhabetic(word) && !stopWords.contains(word)) {
                filteredWords.add(word);
            }
        }
        return filteredWords;
    }
}
