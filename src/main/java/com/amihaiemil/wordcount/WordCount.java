package com.amihaiemil.wordcount;

/**
 * This is the WordCount game.
 * @author Mihai A. (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public interface WordCount {

    /**
     * Start the game.
     * @param text The text to count.
     */
    long count(final String text);

}
