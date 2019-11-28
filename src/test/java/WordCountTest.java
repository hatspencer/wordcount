import org.junit.Test;

import static org.junit.Assert.*;

public class WordCountTest {

    @Test
    public void countWordsShouldHandleSpaces() {
        long result = WordCount.countWords("a b  c   d  ");
        assertEquals(4, result);
    }

    @Test
    public void countWordsShouldHandleTabs() {
        long result = WordCount.countWords("\ta\tb\t\tc\t");
        assertEquals(3, result);
    }

    @Test
    public void countWordsShouldHandleEmptyLine() {
        long result = WordCount.countWords("");
        assertEquals(0, result);

        result = WordCount.countWords(" ");
        assertEquals(0, result);

        result = WordCount.countWords("\t");
        assertEquals(0, result);

        result = WordCount.countWords("\n");
        assertEquals(0, result);
    }

    @Test
    public void countWordsShouldCountOnlyWords() {
        long result = WordCount.countWords("1 1a f` g;");
        assertEquals(0, result);

        result = WordCount.countWords(" 1 1a\tValid \t WORD");
        assertEquals(2, result);
    }
}