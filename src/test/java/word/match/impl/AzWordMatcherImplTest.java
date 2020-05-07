package word.match.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import word.match.impl.AzWordMatcherImpl;
import word.match.WordMatcher;

public class AzWordMatcherImplTest {

    @Test
    public void testEmptyWord() {
        WordMatcher wordMatcher = new AzWordMatcherImpl();
        boolean result = wordMatcher.match("");
        assertFalse(result);
    }

    @Test
    public void testNullWord() {
        WordMatcher wordMatcher = new AzWordMatcherImpl();
        boolean result = wordMatcher.match(null);
        assertFalse(result);
    }

    @Test
    public void testOnlyWhiteSpaceWord() {
        WordMatcher wordMatcher = new AzWordMatcherImpl();
        boolean result1 = wordMatcher.match(" ");
        boolean result2 = wordMatcher.match(" \t");
        assertFalse(result1);
        assertFalse(result2);
    }

    @Test
    public void testAzWord() {
        WordMatcher wordMatcher = new AzWordMatcherImpl();
        boolean result = wordMatcher.match("text");
        assertTrue(result);
    }

    @Test
    public void testEmptyAzMultipleCasesWord() {
        WordMatcher wordMatcher = new AzWordMatcherImpl();
        boolean result = wordMatcher.match("tExT");
        assertTrue(result);
    }

    @Test
    public void testSpecialCharWord() {
        WordMatcher wordMatcher = new AzWordMatcherImpl();
        boolean result1 = wordMatcher.match("*text");
        boolean result2 = wordMatcher.match("tExt ");
        boolean result3 = wordMatcher.match("teXt&dsad");
        boolean result4 = wordMatcher.match("tExt&");
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
        assertFalse(result4);
    }

}