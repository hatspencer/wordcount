package com.erste.main;

import java.util.Scanner;

import com.erste.main.util.StringUtil;

public class Main {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS = "Number of words: %s";

    private Scanner scanner;

    public static void main(String[] args) {
        new Main(new Scanner(System.in));
    }

    public Main(Scanner scanner) {
        this.scanner = scanner;
    }

    public int run() {
        System.out.print(ENTER_TEXT);
        int wordCount = StringUtil.getWordCountInString(scanner.nextLine());
        System.out.println(String.format(NUMBER_OF_WORDS, wordCount));

        return wordCount;
    }
}
