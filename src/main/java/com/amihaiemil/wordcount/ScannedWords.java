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
     * The counting strategies to use.
     */
    private WordCount[] counters;

    /**
     * Ctor.
     * @param scan Given scanner.
     * @param strategies The counting strategies to use.
     */
    public ScannedWords(final Scanner scan, final WordCount... strategies) {
        this.scan = scan;
        this.counters = strategies;
    }


    public void start() {
        System.out.print("Enter text: ");
        String input = this.scan.nextLine();
        System.out.println("Your text is: " + input);
        System.out.println("Your word counts are: ");
        for(final WordCount counter : this.counters) {
            System.out.println (counter.count(input));
        }
    }
}
