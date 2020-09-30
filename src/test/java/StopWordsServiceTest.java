import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class StopWordsServiceTest {

    private StopWordsService stopWordsService;

    @Before
    public void initilize() {
        stopWordsService = new StopWordsService();
    }

    @Test
    public void shouldLoadStopwordsFromResource() {
        Set<String> stopwords = stopWordsService.getStopWords();

        Set<String> expectedStopwords = new HashSet<>(Arrays.asList("the", "a", "on", "off"));

        assertEquals(4, stopwords.size());
        assertEquals(expectedStopwords, stopwords);
    }
}
