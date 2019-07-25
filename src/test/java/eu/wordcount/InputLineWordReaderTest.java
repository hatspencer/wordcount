package eu.wordcount;

import eu.wordcount.reader.InputLineWordReader;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class InputLineWordReaderTest {

    private InputLineWordReader underTest;
    private InputStream inputStream;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void whenInputStreamSuppliesTheSentence_thenItShouldBeReturnedByTheWordReader() {
        inputStream = new ByteArrayInputStream("Mary had a little lamb\n".getBytes());
        underTest = new InputLineWordReader(inputStream);
        final String actual = underTest.readWords();
        final String expected = "Mary had a little lamb";
        assertEquals("Sentence should be as expected", expected, actual);
    }

    @Test
    public void whenInputStreamProducesIOException_thenShouldReturnNull() {
        inputStream = new InputStream() {
            @Override
            public int read() throws IOException {
                throw new IOException();
            }
        };
        underTest = new InputLineWordReader(inputStream);

        String actual = underTest.readWords();
        assertNull("Reader should return null", actual);
    }
}
