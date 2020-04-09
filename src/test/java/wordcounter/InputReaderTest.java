package wordcounter;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class InputReaderTest {

    @Test
    public void readFromSystemIn() {
        System.setIn(new ByteArrayInputStream("Word Word".getBytes()));

        InputReader sut = new InputReader();
        String stringFromSystemIn = sut.readFromSystemIn("Enter text: ");

        assertEquals("Word Word", stringFromSystemIn);
    }
}