package eu.wordcount.reader;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertEquals;

public class FileWordReaderTest {

    private FileWordReader underTest;

    @Before
    public void setUp() {
        File file = new File(getClass().getClassLoader().getResource("inputwords.txt").getFile());
        underTest = new FileWordReader(file);
    }

    @Test
    public void whenReadingAFileWithMultipleLines_thenShouldReturnConcatenatedLinesSeparatedWithSpaces() {
        final String actual = underTest.readWords();
        final String expected = "Mary had a little lamb";
        assertEquals("Words returned by the reader should match expectations", expected, actual);
    }
}
