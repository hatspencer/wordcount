package com.erste.main;

import java.util.ArrayList;
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
    private String fileName;

    public static void main(String[] args) {
        new Main(new Scanner(System.in), args).run();
    }

    public Main(Scanner scanner, String[] args) {
        this.scanner = scanner;

        if (args.length == 1) {
            fileName = args[0];
        } else if (args.length > 1) {
            System.err.println("Please provide at most one argument: file name");
            System.exit(0);
        }
    }

    private void run() {
        final List<String> processedInputAsWords = new ArrayList<>();

        if (fileName != null) {
            List<String> fileLines = FileReader.readFileAsLines(fileName);
            fileLines.forEach(line -> processedInputAsWords.addAll(StringUtil.getWhiteSpaceSeparatedWords(line)));
        } else {
            System.out.print(ENTER_TEXT);
            processedInputAsWords.addAll(StringUtil.getWhiteSpaceSeparatedWords(scanner.nextLine()));
        }

        List<String> readFileLines = FileReader.readFileAsLines(STOPWORDS_FILE_NAME);
        List<String> wordsWithoutStopWords = new StopWordFilter().filterOutStopWords(readFileLines, processedInputAsWords);

        System.out.println(String.format(NUMBER_OF_WORDS, countAlphabeticWords(wordsWithoutStopWords)));
    }

    private long countAlphabeticWords(List<String> words) {
        return words.stream().filter(StringUtil::isAlhabetic).count();
    }
}
