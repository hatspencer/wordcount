package com.amihaiemil.wordcount;

import java.util.Scanner;

/**
 * Main class. Entry point of the app.
 * @author Mihai A. (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class Main {

    /**
     * Entry.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        final ScannedWords game = new ScannedWords(
            new Scanner(System.in),
            new IgnoresEmpty(
                new SimpleCount()
            )
        );
        game.start();
    }

}
