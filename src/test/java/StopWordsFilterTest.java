import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class StopWordsFilterTest {

    @Test
    public void filterShouldFilterOutStopWords() {
        Set<String> stopWords = new HashSet<>(Arrays.asList("stop", "word"));
        List<String> input = Arrays.asList("stop", "word", "hello", "world");

        StopWordsFilter stopWordsFilter = new StopWordsFilter(stopWords);
        List<String> result = stopWordsFilter.filter(input);

        assertEquals(Arrays.asList("hello", "world"), result);
    }

}