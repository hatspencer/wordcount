import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InputTextParserTest {

    private InputTextParser inputTextParser;

    @Before
    public void setUp() throws Exception {
        inputTextParser = new InputTextParser();
    }

    @Test
    public void findWordsShouldHandleSpaces() {
        List<String> result = inputTextParser.findWords("a b  c   d  ");
        assertEquals(4, result.size());
    }

    @Test
    public void findWordsShouldHandleTabs() {
        List<String> result = inputTextParser.findWords("\ta\tb\t\tc\t");
        assertEquals(3, result.size());
    }

    @Test
    public void findWordsShouldHandleEmptyLine() {
        List<String> result = inputTextParser.findWords("");
        assertEquals(0, result.size());

        result = inputTextParser.findWords(" ");
        assertEquals(0, result.size());

        result = inputTextParser.findWords("\t");
        assertEquals(0, result.size());

        result = inputTextParser.findWords("\n");
        assertEquals(0, result.size());
    }

    @Test
    public void findWordsShouldCountOnlyWords() {
        List<String> result = inputTextParser.findWords("1 1a f` don't g;");
        assertEquals(4, result.size());

        result = inputTextParser.findWords(" 1 1a\tValid \t WORD");
        assertEquals(2, result.size());
    }

    @Test
    public void findWordsShouldRecognizeNonWordCharacters() {
        List<String> result = inputTextParser.findWords("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.");
        List<String> expected = Arrays.asList("Humpty", "Dumpty", "sat", "on", "a", "wall", "Humpty", "Dumpty", "had", "a", "great", "fall");

        assertEquals(expected, result);
    }

}