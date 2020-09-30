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
        stopWords.add("on");
        stopWords.add("off");

        SanitizingService sanitizingService = ;

        countService = new CountService(sanitizingService);
    }

    @Test
    public void shouldReturn0WhenPassedNull() {
        Statistics result = countService.countWords(null);
        assertEquals(0, result.getAllWordCount());
        assertEquals(0, result.getUniqueWordCount());
    }

    @Test
    public void shouldReturn0WhenPassedEmptyString() {
        Statistics result = countService.countWords("");
        assertEquals(0, result.getAllWordCount());
        assertEquals(0, result.getUniqueWordCount());
    }

    @Test
    public void shouldReturn0WhenPassedBlankString() {
        Statistics result = countService.countWords("  ");
        assertEquals(0, result.getAllWordCount());
        assertEquals(0, result.getUniqueWordCount());
    }

    @Test
    public void shouldCountCorrectlyWordsWithNumbers() {
        Statistics  result = countService.countWords("wor3d test test");
        assertEquals(2, result.getAllWordCount());
        assertEquals(1, result.getUniqueWordCount());
    }

    @Test
    public void shouldCountCorrectlyWordsSeparatedWithTabs() {
        Statistics result = countService.countWords("test  test");
        assertEquals(2, result.getAllWordCount());
        assertEquals(1, result.getUniqueWordCount());
    }

    @Test
    public void shouldNotCountStopWords() {
        Statistics result = countService.countWords("test a test");
        assertEquals(2, result.getAllWordCount());
        assertEquals(1, result.getUniqueWordCount());
    }

    @Test
    public void shouldCountCorrectlyWithSpecialCharacters() {
        Statistics result = countService.countWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(9, result.getAllWordCount());
        assertEquals(7, result.getUniqueWordCount());
    }

}
