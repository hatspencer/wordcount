package com.amihaiemil.wordcount;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A counter which will only count unique words.
 * @author MIhai A. (amihaiemil@gmail.com)
 * @version $Id$
 * @since 0.0.1
 */
public final class UniqueWordsCounter extends AbstractWordCount {

    /**
     * Ctor. By default no words are ignored.
     */
    public UniqueWordsCounter() {
        this(new HashSet<>());
    }

    /**
     * Ctor.
     * @param skipped Given list of ignored words.
     */
    public UniqueWordsCounter(final Set<String> skipped) {
        super(skipped);
    }

    @Override
    public long count(final String text) {
        final Set<String> unique = new HashSet<>(Arrays.asList(text.split(" ")));
        int count = 0;
        for(final String word : unique) {
            if(!this.skipped.contains(word)) {
                count++;
            }
        }
        return count;    }

}
