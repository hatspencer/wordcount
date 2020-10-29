import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StopWordReaderTest {


    @Before
    public void init() {
    }

    @Test
    public void givenFile_returnListOfWords() {
        StopWordReader stopWordReader = new StopWordReader("src/main/resources/stopwords.txt");

        List<String> actual = stopWordReader.readStopWords();
        List<String> expected = new ArrayList<>(Arrays.asList("the", "a", "on", "off"));

        assertEquals(expected, actual);
    }
}
