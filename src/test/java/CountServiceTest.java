import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountServiceTest {

    private CountService countService;

    @Before
    public void initilize() {
        countService = new CountService();
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


}
