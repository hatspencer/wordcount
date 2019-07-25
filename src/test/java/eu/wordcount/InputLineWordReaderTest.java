package eu.wordcount;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class InputLineWordReaderTest {

    private InputLineWordReader underTest;
    private InputStream inputStream;

    @Before
    public void setUp() throws Exception {
        inputStream = new ByteArrayInputStream("Mary had a little lamb\n".getBytes());
        underTest = new InputLineWordReader(inputStream);
    }

    @Test
    public void whenInputStreamSuppliesTheSentence_thenItShouldBeReturnedByTheWordReader() {

        final String actual = underTest.readWords();
        final String expected = "Mary had a little lamb";
        assertEquals("Sentence should be as expected", expected, actual);
    }
}
