package com.dan.application;

import com.dan.wordcounter.WordCounter;
import com.dan.wordcounter.WordCounterImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        WordCounter counter = new WordCounterImpl();

        int wordCount = counter.countWords(line);

        System.out.println("Number of words: " + wordCount);

        scanner.close();
    }

}
