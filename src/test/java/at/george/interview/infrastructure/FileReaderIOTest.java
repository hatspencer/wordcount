package at.george.interview.infrastructure;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileReaderIOTest {

    @Test
    public void returnEmptyOnMissingFile() {
        FileReaderIO sut = new FileReaderIO(new File("/a/b/c"));

        String input = sut.readTextInputLine();

        assertEquals("", input);
    }

    @Test
    public void returnContentOfExistingFile() {
        FileReaderIO sut = new FileReaderIO(new File("src/test/resources/sampleinput.txt"));

        String input = sut.readTextInputLine();

        assertEquals("Mary had a little lamb", input.trim());
    }

}