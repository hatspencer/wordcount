package com.dan.application;

import com.dan.wordcounter.WordCounter;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        WordCounter counter = new WordCounter();

        int wordCount = counter.countWords(line);

        System.out.println(wordCount);

        scanner.close();

    }

}
