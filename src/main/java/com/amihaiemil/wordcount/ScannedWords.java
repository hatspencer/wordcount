package com.amihaiemil.wordcount;

import java.util.Scanner;

/**
 * Word count game from console input.
 */
public final class ScannedWords {

    /**
     * Scanner to use.
     */
    private final Scanner scan;

    /**
     * The counting strategy to use.
     */
    private WordCount counter;

    /**
     * Ctor.
     * @param scan Given scanner.
     * @param strategy The counting strategy to use.
     */
    public ScannedWords(final Scanner scan, final WordCount strategy) {
        this.scan = scan;
        this.counter = strategy;
    }


    public void start() {
        System.out.print("Enter text: ");
        String input = this.scan.nextLine();
        System.out.println("Your text is: " + input);
        System.out.println("Your word count is: " + this.counter.count(input));
    }
}
