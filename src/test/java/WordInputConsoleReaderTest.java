import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class WordInputConsoleReaderTest {

    private WordInputConsoleReader wordInputConsoleReader;

    @Test
    public void givenInputText_returnContentAsString() {
        ByteArrayInputStream mockInStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(mockInStream);
        wordInputConsoleReader = new WordInputConsoleReader();

        String actual = wordInputConsoleReader.processInput();
        String expected = "Mary had a little lamb";

        assertEquals(expected, actual);
    }
}
