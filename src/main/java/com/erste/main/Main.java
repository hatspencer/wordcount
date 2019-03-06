package com.erste.main;

import java.util.List;
import java.util.Scanner;

import com.erste.main.io.FileReader;
import com.erste.main.util.StopWordFilter;
import com.erste.main.util.StringUtil;

public class Main {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS = "Number of words: %s";
    private static final String STOPWORDS_FILE_NAME = "stopwords.txt";

    private Scanner scanner;

    public static void main(String[] args) {
        new Main(new Scanner(System.in)).run();
    }

    public Main(Scanner scanner) {
        this.scanner = scanner;
    }

    private void run() {
        System.out.print(ENTER_TEXT);
        List<String> readFileLines = FileReader.readFileAsLines(STOPWORDS_FILE_NAME);
        String[] processedInputAsWords = StringUtil.getWhiteSpaceSeparatedWords(scanner.nextLine());
        List<String> wordsWithoutStopWords = new StopWordFilter().filterOutStopWords(readFileLines, processedInputAsWords);

        System.out.println(String.format(NUMBER_OF_WORDS, countAlphabeticWords(wordsWithoutStopWords)));
    }

    private long countAlphabeticWords(List<String> words) {
        return words.stream().filter(StringUtil::isAlhabetic).count();
    }
}
