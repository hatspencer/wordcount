package eu.wordcount;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class WordCountApp {

    public static void main(String[] args) {

        System.out.print("Enter text: ");

        String input = new WordReader().readWords(new BufferedReader(new InputStreamReader(System.in)));
        int wordsCount = new WordCounter().countWords(input);

        System.out.println(String.format("Number of words: %d", wordsCount));
    }
}
