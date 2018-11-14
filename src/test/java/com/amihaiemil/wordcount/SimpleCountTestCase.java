package com.amihaiemil.wordcount;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link SimpleCount}.
 */
public final class SimpleCountTestCase {

    /**
     * SimpleCount can count the words from a non-empty String.
     */
    @Test
    public void countsWords() {
        final SimpleCount text = new SimpleCount();
        Assert.assertEquals(4, text.count("Mary had a lamb"));
    }

}
