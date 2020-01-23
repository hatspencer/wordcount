import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ApplicationTest {

    @Test
    public void expectStopwordsToBeNotNull() throws IOException {
        List<String> stopWords = Application.getStopwords();
        Assertions.assertNotNull(stopWords);
    }


    @Test
    public void expectGetStopwordsToReturnPopulatedList() throws IOException {
        List<String> expectedStopwordsList = Arrays.asList("the","a","on","off");
        List<String> actualStopWords = Application.getStopwords();
        Assertions.assertEquals(expectedStopwordsList,actualStopWords);
    }
}
