package com.amihaiemil.wordcount;

import java.util.Set;

/**
 * Abstract WordCount. It should be extended by all implementations since it provides
 * the set of words to be ommited from the count.
 */
abstract class AbstractWordCount implements WordCount {
    /**
     * Words that are skipped in the count.
     */
    final Set<String> skipped;

    /**
     * Ctor.
     */
    AbstractWordCount(final Set<String> skipped) {
        this.skipped = skipped;

    }
}
