import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class SanitizingServiceTest {

    private SanitizingService sanitizingService;

    @Before
    public void initialize() {
        Set<String> stopWords = new HashSet<>();
        stopWords.add("a");
        stopWords.add("the");
        stopWords.add("on");
        stopWords.add("off");

        sanitizingService = new SanitizingServiceImpl(stopWords);
    }

    @Test
    public void shouldReturnEmptyWhenPassedNull() {
        List<String> result = sanitizingService.getSanitizedWords(null);
        assertEquals(0, result.size());
    }


    @Test
    public void shouldReturnEmptyListWhenPassedEmptyString() {
        List<String> result = sanitizingService.getSanitizedWords("");
        assertEquals(0, result.size());
    }

    @Test
    public void shouldReturnEmptyListWhenPassedBlankString() {
        List<String> result = sanitizingService.getSanitizedWords("  ");
        assertEquals(0, result.size());
    }

    @Test
    public void shouldParseCorrectlyWordsSeparatedWithTabs() {
        List<String> result = sanitizingService.getSanitizedWords("test  test");
        assertEquals(2, result.size());
        assertEquals(Arrays.asList("test", "test"),result);
    }

    @Test
    public void shouldNotIncludeStopWords() {
        List<String> result = sanitizingService.getSanitizedWords("test a test");
        assertEquals(2, result.size());
        assertEquals(Arrays.asList("test", "test"),result);
    }

    @Test
    public void shouldNotIncludeWordsWithNumbers() {
        List<String> result = sanitizingService.getSanitizedWords("wor3d test test");
        assertEquals(2, result.size());
        assertEquals(Arrays.asList("test", "test"),result);
    }

    @Test
    public void shouldIncludeWordsWithHyphenAsOne() {
        List<String> result = sanitizingService.getSanitizedWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        assertEquals(7, result.size());
        assertEquals(Arrays.asList("Humpty-Dumpty","sat","wall", "Humpty-Dumpty", "had", "great", "fall"),result);
    }
}