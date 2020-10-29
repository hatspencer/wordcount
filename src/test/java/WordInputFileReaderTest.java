import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WordInputFileReaderTest {

    @Test
    public void givenInputFile_returnContentAsOneLineString() throws IOException {
        File inputFile = new File("src/test/resources/input.txt");
        WordInputFileReader wordInputFileReader = new WordInputFileReader(inputFile);

        String expected = "Mary had a little lamb";
        String actual = wordInputFileReader.processInput();

        assertEquals(expected, actual);
    }

    @Test(expected = IOException.class)
    public void givenInvalidInputFile_throwIOException() throws IOException {
        File invalidInputFile = new File("src/test/resources/input.old.txt");
        WordInputFileReader wordInputFileReader = new WordInputFileReader(invalidInputFile);

        wordInputFileReader.processInput();
    }
}
