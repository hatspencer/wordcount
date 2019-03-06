package com.erste.main;

import java.util.Scanner;

public class Main {

    private static final String ENTER_TEXT = "Enter text: ";
    private static final String NUMBER_OF_WORDS = "Number of words: %s";

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.print(ENTER_TEXT);
        System.out.println(String.format(NUMBER_OF_WORDS, getWordCountInString(scanner.nextLine())));
    }

    public int getWordCountInString(String input) {
       return input.split("\\s").length;
    }
}
