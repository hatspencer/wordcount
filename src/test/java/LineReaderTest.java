import org.junit.Test;
import util.LineReader;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Marton Bartal on 15.10.2020.
 * Test for reading words from a file
 */
public class LineReaderTest {

    private static final String STOPWORDS_FILENAME = "stopwords.txt";
    private static final String NOT_FOUND_FILENAME = "UNKNOWN";
    private final LineReader lineReader = new LineReader(STOPWORDS_FILENAME);

    @Test
    public void testReadCorrectWords() {
        List<String> expectedStopWords = Arrays.asList("aa", "the", "on", "off");
        List<String> actualStopWords = lineReader.readLinesFromFile();

        assertEquals("Wrong amount of words read.", expectedStopWords.size(), actualStopWords.size());
        for (String expectedWord : expectedStopWords) {
            assertTrue("Word was expected, but was not read.", actualStopWords.contains(expectedWord));
        }
    }

    @Test
    public void testFileNotFound() {
        LineReader lineReader = new LineReader(NOT_FOUND_FILENAME);
        List<String> actualStopWords = lineReader.readLinesFromFile();

        assertEquals("Wrong amount of words read.", 0, actualStopWords.size());
    }
}
