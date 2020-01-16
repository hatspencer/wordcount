package userinput;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ConsoleInputReaderTest {

    @Test
    public void testNonemptyFile() {
        InputStream inputStream = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        UserInputReader toTest = new ConsoleInputReader(inputStream);
        Assert.assertEquals("Mary had a little lamb", toTest.readUserInput());
    }
}
