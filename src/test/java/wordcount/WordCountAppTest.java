package wordcount;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.Assert.*;

public class WordCountAppTest {

    @Test
    public void testRun() throws IOException {
        StringWriter sw = new StringWriter();
        new WordCountApp(new StringReader("Mary had a little lamb"), new PrintWriter(sw));
        assertEquals("Enter text: Number of words: 4\n", sw.toString());
    }

    @Test
    public void testInputProvidedFromCommandLine() throws IOException {
        StringWriter sw = new StringWriter();
        new WordCountApp(new StringReader(""), new PrintWriter(sw), "src/test/resources/wordcount/mytext.txt");
        assertEquals("Enter text: Number of words: 4\n", sw.toString());
    }

}