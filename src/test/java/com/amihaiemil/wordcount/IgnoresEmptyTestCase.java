package com.amihaiemil.wordcount;

import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.anyString;

/**
 * Unit tests {@link IgnoresEmpty}.
 */
public final class IgnoresEmptyTestCase {

    public static final String EMPTY_STRING = "";
    public static final String NULL_INPUT = null;

    /**
     * IgnoresEmpty can count the words from an empty String.
     */
    @Test
    public void ignoresEmptyString() {
        final WordCount delegated = mock(WordCount.class);

        final WordCount counter = new IgnoresEmpty(delegated);
        Assert.assertEquals(0, counter.count(EMPTY_STRING));

        verify(delegated, never()).count(anyString());
    }

    /**
     * IgnoresEmpty can count the words from a null String.
     */
    @Test
    public void ignoresNull() {
        final WordCount delegated = mock(WordCount.class);

        final WordCount counter = new IgnoresEmpty(delegated);
        Assert.assertEquals(0, counter.count(NULL_INPUT));

        verify(delegated, never()).count(anyString());
    }

}
