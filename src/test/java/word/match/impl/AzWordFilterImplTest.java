package word.match.impl;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import word.match.WordFilter;

public class AzWordFilterImplTest {

    @Test
    public void testEmptyWord() {
        WordFilter wordFilter = new AzWordFilterImpl();
        boolean result = wordFilter.filter("");
        assertFalse(result);
    }

    @Test
    public void testNullWord() {
        WordFilter wordFilter = new AzWordFilterImpl();
        boolean result = wordFilter.filter(null);
        assertFalse(result);
    }

    @Test
    public void testOnlyWhiteSpaceWord() {
        WordFilter wordFilter = new AzWordFilterImpl();
        boolean result1 = wordFilter.filter(" ");
        boolean result2 = wordFilter.filter(" \t");
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    public void testAzWord() {
        WordFilter wordFilter = new AzWordFilterImpl();
        boolean result = wordFilter.filter("text");
        assertTrue(result);
    }

    @Test
    public void testEmptyAzMultipleCasesWord() {
        WordFilter wordFilter = new AzWordFilterImpl();
        boolean result = wordFilter.filter("tExT");
        assertTrue(result);
    }

    @Test
    public void testSpecialCharWord() {
        WordFilter wordFilter = new AzWordFilterImpl();
        boolean result1 = wordFilter.filter("*text");
        boolean result2 = wordFilter.filter("tExt ");
        boolean result3 = wordFilter.filter("teXt&dsad");
        boolean result4 = wordFilter.filter("tExt&");
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
    }

}