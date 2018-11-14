package com.amihaiemil.wordcount;

public class IgnoresEmpty implements WordCount{

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
