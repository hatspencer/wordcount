package com.erste.main;

import java.util.List;
import java.util.Scanner;

import com.erste.main.io.FileReader;
import com.erste.main.util.StringFilter;
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
        List<String> readFileLines = FileReader.readFileAsLines(STOPWORDS_FILE_NAME);
        String[] processedInputAsWords = StringUtil.getWhiteSpaceSeparatedWords(scanner.nextLine());

        int wordCount = new StringFilter().filterOutStrings(readFileLines, processedInputAsWords).size();
        System.out.println(String.format(NUMBER_OF_WORDS, wordCount));

        return wordCount;
    }
}
