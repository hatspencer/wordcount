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
        SanitizingService sanitizingService = new SanitizingServiceImpl(stopwords);
        countService = new CountService(sanitizingService);
    }

    @Test
    public void shouldNotCountStopwords() {
        Statistics result = countService.countWords("Mary had a little lamb");
        assertEquals(4, result.getAllWordCount());
        assertEquals(4, result.getUniqueWordCount());
    }
}
