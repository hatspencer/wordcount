import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.assertEquals;

public class StopWordsFileReaderTest {

    private static final String PATH_TO_RESOURCE = "stopwords.txt";

    @Test
    public void shouldFindFileInResources() {
        new StopWordsFileReader(PATH_TO_RESOURCE).getStopWords();
    }

    @Test
    public void shouldReadStopWords() {
        Set<String> stopwords = new StopWordsFileReader(PATH_TO_RESOURCE).getStopWords();

        assertEquals(3, stopwords.size());
    }
}