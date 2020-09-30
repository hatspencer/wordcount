import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class CountServiceTest {

    private CountService countService;

    @Test
    public void shouldCount0WhenPassedNull() {
        countService = new CountService(getSanitizingServiceMock(new ArrayList<>()));
        Statistics result = countService.countWords(null);
        assertEquals(0, result.getAllWordCount());
        assertEquals(0, result.getUniqueWordCount());
        assertEquals(0, result.getAverageLength(), 0.0001);
    }

    @Test
    public void shouldCountCorrectlyDuplicateWords() {
        countService = new CountService(getSanitizingServiceMock(Arrays.asList("Humpty", "Dumpty", "sat", "wall", "Humpty", "Dumpty", "had", "great", "fall")));
        Statistics result = countService.countWords("Humpty Dumpty sat on a wall. Humpty Dumpty had a great fall.");
        assertEquals(9, result.getAllWordCount());
        assertEquals(7, result.getUniqueWordCount());
        assertEquals(4.77777, result.getAverageLength(), 0.0001);
    }

    private SanitizingService getSanitizingServiceMock(List<String> expected) {
        return new SanitizingService() {
            @Override
            public List<String> getSanitizedWords(String text) {
                return expected;
            }
        };
    }

}
