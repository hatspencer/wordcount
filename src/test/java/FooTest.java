import org.junit.Test;

import static org.junit.Assert.*;

public class FooTest {

    @Test
    public void wordValidityTest() {

        // ok
        assertTrue(Foo.isWord("word"));
        assertTrue(Foo.isWord("WOrd"));
        assertTrue(Foo.isWord("WORD"));

        // fail
        assertFalse(Foo.isWord("wo2rd"));
        assertFalse(Foo.isWord(""));
        assertFalse(Foo.isWord("  "));
    }

    @Test
    public void wordCountTest() {

        assertEquals(1, Foo.countWords("word"));
        assertEquals(2, Foo.countWords("word word"));
        assertEquals(2, Foo.countWords("  word    6fdf  uionj"));
        assertEquals(0, Foo.countWords("   "));

    }

}
