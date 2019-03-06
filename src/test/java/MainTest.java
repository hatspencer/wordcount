import com.erste.main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    private static final String TEST_QUOTE = "Hello World";

    @Test
    public void wordCountTest() {
        Main main = new Main();
        int wordCount = main.getWordCountInString(TEST_QUOTE);
        Assertions.assertEquals(2, wordCount);
    }
}
