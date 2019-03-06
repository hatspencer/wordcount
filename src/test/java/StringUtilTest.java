import java.util.List;

import com.erste.main.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringUtilTest {

    private static final String TEST_QUOTE = "Hello World";
    private static final String ALPHABETIC_WORD = "ERSTE";
    private static final String ALPHANUMERIC_WORD = "ERSTE123344";

    @Test
    public void getWordsByWhitespaceSplit() {
        List<String> whiteSpaceSeparatedWords = StringUtil.getWhiteSpaceSeparatedWords(TEST_QUOTE);
        Assertions.assertEquals(2, whiteSpaceSeparatedWords.size());
        Assertions.assertEquals(whiteSpaceSeparatedWords.get(0), "Hello");
        Assertions.assertEquals(whiteSpaceSeparatedWords.get(1), "World");
    }

    @Test
    public void isAlphabeticExpectTrue() {
        Assertions.assertTrue(StringUtil.isAlhabetic(ALPHABETIC_WORD));
    }

    @Test
    public void isAlphabeticExpectFalse() {
        Assertions.assertFalse(StringUtil.isAlhabetic(ALPHANUMERIC_WORD));
    }
}
