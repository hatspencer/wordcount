import org.junit.Test;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Test
    public void getInputReaderShouldReturnNullForTooManyArguments() {
        InputReader result = Application.getInputReader(new String[]{"one", "two"});

        assertNull(result);
    }

    @Test
    public void getInputReaderShouldReturnCommandLineInputReaderForZeroArguments() {
        InputReader result = Application.getInputReader(new String[]{});

        assertTrue(result instanceof CommandLineInputReader);
    }

    @Test
    public void getInputReaderShouldReturnFileInputReaderForSingleArgument() {
        InputReader result = Application.getInputReader(new String[]{"one"});

        assertTrue(result instanceof FileInputReader);
    }

}