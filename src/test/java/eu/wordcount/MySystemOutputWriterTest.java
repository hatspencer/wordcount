package eu.wordcount;

import eu.wordcount.writer.MySystemOutputWriter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class MySystemOutputWriterTest {

    private MySystemOutputWriter underTest;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        underTest = new MySystemOutputWriter(new PrintStream(outputStream));
    }

    @Test
    public void write() {
        String expected = "test string to be written";
        underTest.write(expected);
        String actual = outputStream.toString();
        assertEquals("Output stream content should match the input", expected, actual);
    }
}
