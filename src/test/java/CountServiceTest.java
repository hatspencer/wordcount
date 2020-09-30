import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CountServiceTest {

    private CountService countService;

    @Before
    public void initilize() {
        Set<String> stopWords = new HashSet<>();
        stopWords.add("a");
        stopWords.add("the");

        countService = new CountService(stopWords);
    }

    @Test
    public void shouldReturn0WhenPassedNull() {
        int result = countService.countWords(null);
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn0WhenPassedEmptyString() {
        int result = countService.countWords("");
        assertEquals(0, result);
    }

    @Test
    public void shouldReturn0WhenPassedBlankString() {
        int result = countService.countWords("  ");
        assertEquals(0, result);
    }

    @Test
    public void shouldCountCorrectlyWordsWithNumbers() {
        int result = countService.countWords("wor3d test test");
        assertEquals(2, result);
    }

    @Test
    public void shouldCountCorrectlyWordsSeparatedWithTabs() {
        int result = countService.countWords("test  test");
        assertEquals(2, result);
    }

    @Test
    public void shouldNotCountStopWords() {
        int result = countService.countWords("test a test");
        assertEquals(2, result);
    }

}
