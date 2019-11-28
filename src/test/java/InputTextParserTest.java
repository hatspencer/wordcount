import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class InputTextParserTest {

    private InputTextParser inputTextParser;

    @Before
    public void setUp() throws Exception {
        inputTextParser = new InputTextParser();
    }

    @Test
    public void countWordsShouldHandleSpaces() {
        List<String> result = inputTextParser.parse("a b  c   d  ");
        assertEquals(4, result.size());
    }

    @Test
    public void countWordsShouldHandleTabs() {
        List<String> result = inputTextParser.parse("\ta\tb\t\tc\t");
        assertEquals(3, result.size());
    }

    @Test
    public void countWordsShouldHandleEmptyLine() {
        List<String> result = inputTextParser.parse("");
        assertEquals(0, result.size());

        result = inputTextParser.parse(" ");
        assertEquals(0, result.size());

        result = inputTextParser.parse("\t");
        assertEquals(0, result.size());

        result = inputTextParser.parse("\n");
        assertEquals(0, result.size());
    }

    @Test
    public void countWordsShouldCountOnlyWords() {
        List<String> result = inputTextParser.parse("1 1a f` g;");
        assertEquals(0, result.size());

        result = inputTextParser.parse(" 1 1a\tValid \t WORD");
        assertEquals(2, result.size());
    }

}