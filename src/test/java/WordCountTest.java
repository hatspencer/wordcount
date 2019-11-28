import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class WordCountTest {

    @Test
    public void getInputReaderShouldReturnNullForTooManyArguments() {
        InputReader result = WordCount.getInputReader(new String[]{"one", "two"});

        assertNull(result);
    }

    @Test
    public void getInputReaderShouldReturnCommandLineInputReaderForZeroArguments() {
        InputReader result = WordCount.getInputReader(new String[]{});

        assertTrue(result instanceof CommandLineInputReader);
    }

    @Test
    public void getInputReaderShouldReturnFileInputReaderForSingleArgument() {
        InputReader result = WordCount.getInputReader(new String[]{"one"});

        assertTrue(result instanceof FileInputReader);
    }

}