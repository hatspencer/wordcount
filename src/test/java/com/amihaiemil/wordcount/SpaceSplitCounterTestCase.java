package com.amihaiemil.wordcount;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Unit tests for {@link SpaceSplitCounter}.
 */
public final class SpaceSplitCounterTestCase {

    /**
     * SpaceSplitCounter can count the words from a non-empty String.
     */
    @Test
    public void countsWords() {
        final SpaceSplitCounter text = new SpaceSplitCounter();
        Assert.assertEquals(4, text.count("Mary had a lamb"));
    }

    /**
     * SpaceSplitCounter can skip some specified words from the count.
     */
    @Test
    public void skipsSpecifiedWords() {
        final SpaceSplitCounter text = new SpaceSplitCounter(
            new HashSet<>(Arrays.asList("had", "a"))
        );
        Assert.assertEquals(2, text.count("Mary had a lamb"));
    }

}
