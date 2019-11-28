import org.junit.Test;

import static org.junit.Assert.*;

public class WordCountTest {

    @Test
    public void countWordsSpaces() {
        long result = WordCount.countWords("a b  c   d  ");
        assertEquals(4, result);
    }

    @Test
    public void countWordsTabs() {
        long result = WordCount.countWords("\ta\tb\t\tc\t");
        assertEquals(3, result);
    }

    @Test
    public void countWordsEmptyLine() {
        long result = WordCount.countWords("");
        assertEquals(0, result);

        result = WordCount.countWords(" ");
        assertEquals(0, result);

        result = WordCount.countWords("\t");
        assertEquals(0, result);

        result = WordCount.countWords("\n");
        assertEquals(0, result);
    }
}