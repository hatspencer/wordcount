package com.amihaiemil.wordcount;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * Main class. Entry point of the app.
 * @author Mihai A. (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public class Main {

    public static final String STOPWORDS_FILENAME = "stopwords.txt";

    /**
     * Entry.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        try {
            final ScannedWords app = new ScannedWords(
                new Scanner(System.in),
                new IgnoresEmpty(
                    new SpaceSplitCounter(
                        readStopWords()
                    )
                )
            );
            app.start();
        } catch (final URISyntaxException | IOException ex) {
            System.err.println("There has been an error, sorry!" +  ex.getStackTrace());
        }
    }

    /**
     * Read the contents of stopwords.txt.
     * @return Set of unique words to skip in the count.
     * @throws URISyntaxException If something goes wrong.
     * @throws IOException If something goes wrong.
     */
    public static Set<String> readStopWords() throws URISyntaxException, IOException{
        return new HashSet<>(
            Files.readAllLines(
                Paths.get(
                    Main.class.getClassLoader().getResource(STOPWORDS_FILENAME).toURI()
                )
            )

        );
    }
}
