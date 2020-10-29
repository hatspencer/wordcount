import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WordInputFileReaderTest {

    @Test
    public void givenInputFile_returnContentAsOneLineString() {
        File inputFile = new File("src/test/resources/input.txt");
        WordInputFileReader wordInputFileReader = new WordInputFileReader(inputFile);

        String expected = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        String actual = wordInputFileReader.processInput();

        assertEquals(expected, actual);
    }

    @Test(expected = RuntimeException.class)
    public void givenInvalidInputFile_throwRuntimeException() {
        File invalidInputFile = new File("src/test/resources/input.old.txt");
        WordInputFileReader wordInputFileReader = new WordInputFileReader(invalidInputFile);

        wordInputFileReader.processInput();
    }
}
