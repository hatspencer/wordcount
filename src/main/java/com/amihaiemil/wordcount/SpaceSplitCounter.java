package com.amihaiemil.wordcount;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A word count which separates the words by spaces.
 * @author Mihai A.
 * @version $Id$
 * @since 0.0.1
 */
public final class SpaceSplitCounter implements WordCount {

    /**
     * Words that are skipped in the count.
     */
    private final Set<String> skipped;

    /**
     * Ctor. By default no words are ignored.
     */
    public SpaceSplitCounter() {
        this(new HashSet<>());
    }

    /**
     * Ctor.
     * @param skipped Given list of ignored words.
     */
    public SpaceSplitCounter(final Set<String> skipped) {
        this.skipped = skipped;
    }

    @Override
    public long count(final String text) {
        final String[] words = text.split(" ");
        int count = 0;
        for(final String word : words) {
            if(!this.skipped.contains(word)) {
                count++;
            }
        }
        return count;
    }
}
