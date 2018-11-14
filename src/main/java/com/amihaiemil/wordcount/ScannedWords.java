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
    private WordCount text;

    /**
     * Ctor.
     * @param scan Given scanner.
     */
    public ScannedWords(final Scanner scan, final WordCount count) {
        this.scan = scan;
        this.text = count;
    }


    public void start() {
        System.out.print("Enter text: ");
        String input = this.scan.nextLine();
        System.out.println("Your text is: " + input);
        System.out.println("Your word count is: " + this.text.count(input));
    }
}
