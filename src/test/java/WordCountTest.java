import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class WordCountTest {

    @Test
    public void getWordCountShouldFilterStopWords() {
        Set<String> stopWords = new HashSet<>(Arrays.asList("a", "the"));
        List<String> inputWords = Arrays.asList("a", "the", "valid", "word");

        long result = new WordCount(stopWords, inputWords).getWordCount();

        assertEquals(2, result);
    }

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