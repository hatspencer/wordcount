package com.amihaiemil.wordcount;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

/**
 * Unit tests {@link IgnoresEmpty}.
 */
public final class IgnoresEmptyTestCase {

    /**
     * IgnoresEmpty can count the words from an empty String.
     */
    @Test
    public void countsZeroWords() {
        final String input = "";
        final WordCount mock = Mockito.mock(WordCount.class);

        final WordCount text = new IgnoresEmpty(mock);
        Assert.assertEquals(0, text.count(input));

        Mockito.verify(mock, Mockito.times(0)).count(input);
    }

}
