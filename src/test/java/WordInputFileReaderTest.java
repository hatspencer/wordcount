import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class WordInputFileReaderTest {

    private WordInputFileReader wordInputFileReader;

    @Test
    public void givenInputFile_returnContentAsOneLineString() throws IOException {
        File inputFile = new File("src/test/resources/input.txt");
        wordInputFileReader = new WordInputFileReader(inputFile);

        String expected = "Mary had a little lamb";
        String actual = wordInputFileReader.processInput();

        assertEquals(expected, actual);
    }
}
