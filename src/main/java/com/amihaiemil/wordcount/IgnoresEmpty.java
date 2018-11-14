package com.amihaiemil.wordcount;

/**
 * WordCount which knows to check for null or empty string and directly return 0.
 * @author Mihai A.
 * @version $Id$
 * @since 0.0.1
 */
public final class IgnoresEmpty implements WordCount {

    /**
     * Original word count.
     */
    private final WordCount origin;

    public IgnoresEmpty(final WordCount origin) {
        this.origin = origin;
    }

    @Override
    public long count(final String text) {
        final long count;
        if(text == null || text.isEmpty()) {
            count = 0;
        } else {
            count = this.origin.count(text);
        }
        return count;
    }
}
