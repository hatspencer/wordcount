import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class WordCountMainTest {

    @Test
    public void testEmptyArgs() {
        WordCountMain app = new WordCountMain();
        app.handleArguments(new String[]{});
        assertFalse(app.showIndex);
        assertNull(app.fileName);
        assertNull(app.dictionaryName);
    }

    @Test
    public void testOnlyIndex() {
        WordCountMain app = new WordCountMain();
        app.handleArguments(new String[]{"-index"});
        assertTrue(app.showIndex);
        assertNull(app.fileName);
    }

    @Test
    public void testOnlyFile() {
        WordCountMain app = new WordCountMain();
        app.handleArguments(new String[]{"mytext.txt"});
        assertFalse(app.showIndex);
        assertEquals("mytext.txt", app.fileName);
    }

    @Test
    public void testFileAndIndex() {
        WordCountMain app = new WordCountMain();
        app.handleArguments(new String[]{"mytext.txt", "-index"});
        assertTrue(app.showIndex);
        assertEquals("mytext.txt", app.fileName);
    }

    @Test
    public void testIndexAndFile() {
        WordCountMain app = new WordCountMain();
        app.handleArguments(new String[]{"-index", "mytext.txt"});
        assertTrue(app.showIndex);
        assertEquals("mytext.txt", app.fileName);
    }

    @Test
    public void testDictionary() {
        WordCountMain app = new WordCountMain();
        app.handleArguments(new String[]{"-dictionary=dict.txt"});
        assertFalse(app.showIndex);
        assertNull(app.fileName);
        assertEquals("dict.txt", app.dictionaryName);
    }
}
