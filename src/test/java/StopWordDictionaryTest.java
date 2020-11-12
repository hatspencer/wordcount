import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class StopWordDictionaryTest {

    private static final String TEST_PATH_STOP_WORD = "src/resources/stopwordsTest.txt";
    private StopWordDictionaryImpl stopWordDictionary;

    @Before
    public void init(){
        stopWordDictionary = new StopWordDictionaryImpl();
    }

    @Test
    public void receiveCorrectDictionaryTest(){
        Set<String> dictionary = stopWordDictionary.getStopWordDictionary(TEST_PATH_STOP_WORD);
        assertTrue("Test dictionary does not returns expected word", dictionary.contains("stop"));
        assertTrue("Test dictionary does not returns expected word",dictionary.contains("word"));
    }

    @Test(expected = NullPointerException.class)
    public void receiveNullInputTest(){
        stopWordDictionary.getStopWordDictionary(null);
    }

    @Test
    public void receiveInvalidPathTest(){
        Set<String> dictionary = stopWordDictionary.getStopWordDictionary("");
        assertTrue(dictionary.isEmpty());
    }
}
