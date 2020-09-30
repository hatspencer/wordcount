import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class CountServiceIntegrationTest {

    private CountService countService;
    private StopWordsService stopWordsService;

    @Before
    public void initialize() {
        stopWordsService = new StopWordsService();
        Set<String> stopwords = stopWordsService.getStopWords();
        countService = new CountService(stopwords);
    }

    @Test
    public void shouldNotCountStopwords() {
        int result = countService.countWords("Mary had a little lamb");
        assertEquals(4, result);
    }
}
