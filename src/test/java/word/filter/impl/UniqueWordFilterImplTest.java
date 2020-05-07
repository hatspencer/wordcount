package word.filter.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import word.filter.WordFilter;

public class UniqueWordFilterImplTest {

    @Test
    public void testNullWord() {
        WordFilter wordFilter = new UniqueWordFilterImpl();
        boolean result = wordFilter.filter(null);
        assertTrue(result);
    }

    @Test
    public void testEmptyWord() {
        WordFilter wordFilter = new UniqueWordFilterImpl();
        boolean result = wordFilter.filter("");
        assertTrue(result);
    }

    @Test
    public void testOneWord() {
        WordFilter wordFilter = new UniqueWordFilterImpl();
        boolean result = wordFilter.filter("word");
        assertTrue(result);
    }

    @Test
    public void testNotUniqueWords() {
        WordFilter wordFilter = new UniqueWordFilterImpl();
        boolean result = wordFilter.filter("word");
        assertTrue(result);

        result = wordFilter.filter("word");
        assertFalse(result);
    }

}