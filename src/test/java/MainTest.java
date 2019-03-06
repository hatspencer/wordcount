import java.io.ByteArrayInputStream;
import java.util.Scanner;

import com.erste.main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    private static final String TEST_QUOTE = "Hello World 5ghghj";
    private static final String TEST_QUOTE_WITH_STOPWORDS = "Hello World at ERSTE GROUP IT";

    @Test
    public void wordCount() {
        ByteArrayInputStream bais = new ByteArrayInputStream(TEST_QUOTE.getBytes());
        Main main = new Main(new Scanner(bais));
        int wordCount = main.run();
        Assertions.assertEquals(2, wordCount);
    }

    @Test
    public void wordCountExcludingStopWords() {
        ByteArrayInputStream bais = new ByteArrayInputStream(TEST_QUOTE_WITH_STOPWORDS.getBytes());
        Main main = new Main(new Scanner(bais));
        int wordCount = main.run();
        Assertions.assertEquals(4, wordCount);
    }
}
