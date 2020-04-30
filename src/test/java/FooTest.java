import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class FooTest {

    private static final Set<String> STOP_WORDS = new HashSet<>();

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

        assertEquals(1, Foo.countWords("word", STOP_WORDS));
        assertEquals(2, Foo.countWords("word word", STOP_WORDS));
        assertEquals(2, Foo.countWords("  word    6fdf  uionj", STOP_WORDS));
        assertEquals(0, Foo.countWords("   ", STOP_WORDS));

    }

}
