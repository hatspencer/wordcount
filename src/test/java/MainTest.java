import java.io.ByteArrayInputStream;
import java.util.Scanner;

import com.erste.main.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    private static final String TEST_QUOTE = "Hello World 5ghghj";

    @Test
    public void wordCountTest() {
        ByteArrayInputStream bais = new ByteArrayInputStream(TEST_QUOTE.getBytes());
        Main main = new Main(new Scanner(bais));
        int wordCount = main.run();
        Assertions.assertEquals(2, wordCount);
    }
}
