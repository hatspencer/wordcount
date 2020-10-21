package utils.inputresolver;

import org.junit.Test;
import utils.FileReader;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class FileReaderTest {

    @Test
    public void testValidFileName() {
        final List<String> strings = new FileReader().readFileLines("stopwords.txt");
        assertNotEquals(0, strings.size());
    }

    @Test
    public void testReadValidFileName() {
        final List<String> strings = new FileReader().readFileLines("invalid file");
        assertEquals(0, strings.size());
    }
}
