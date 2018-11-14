package com.amihaiemil.wordcount;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link UniqueWordsCounter}.
 */
public final class UniqueWordsCounterTestCase {

    /**
     * UniqueWordsCounter can count only the unique words.
     */
    @Test
    public void countsOnlyUniqueWords() {
        final UniqueWordsCounter text = new UniqueWordsCounter();
        Assert.assertEquals(5, text.count("Mary had a had lamb Mary george lamb"));
    }

}
