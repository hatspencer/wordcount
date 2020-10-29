import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class ConsoleInputReaderTest {

    private ConsoleInputReader consoleInputReader;

    @Test
    public void givenInputText_returnContentAsString() {
        ByteArrayInputStream mockInStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(mockInStream);
        consoleInputReader = new ConsoleInputReader();

        String actual = consoleInputReader.processInput();
        String expected = "Mary had a little lamb";

        assertEquals(expected, actual);
    }
}
