import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StopWordReaderTest {

    private StopWordReader stopWordReader;

    @Before
    public void init() {
        stopWordReader = new StopWordReader();
    }

    @Test
    public void givenFile_returnListOfWords() {

        List<String> actual = stopWordReader.readStopWords();
        List<String> expected = new ArrayList<>(Arrays.asList("the", "a", "on", "off"));

        assertEquals(expected, actual);
    }
}
