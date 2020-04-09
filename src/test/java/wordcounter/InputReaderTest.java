package wordcounter;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputReaderTest {

    @Test
    public void readFromSystemIn() {
        System.setIn(new ByteArrayInputStream("Word Word".getBytes()));

        InputReader sut = new InputReader();
        String stringFromSystemIn = sut.readFromSystemIn("Enter text: ");

        assertEquals("Word Word", stringFromSystemIn);
    }

    @Test
    public void readFromFile() throws FileNotFoundException {
        InputReader sut = new InputReader();
        List<String> lines = sut.readFromFile("mytext.txt");

        assertEquals(Arrays.asList("Mary had", "a little", "lamb"), lines);
    }
}