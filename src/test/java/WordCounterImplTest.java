import static org.junit.Assert.*;

import org.junit.Test;

public class WordCounterImplTest {

    @Test
    public void test() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count("text");
        assertEquals(1L, count);
    }

    @Test
    public void testWithNullText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count(null);
        assertEquals(0L, count);
    }

    @Test
    public void testWithMultipleWhitespaceTypesText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count("text text\ttext\ntext");
        assertEquals(4L, count);
    }

    @Test
    public void testWithEmptyText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count("");
        assertEquals(0L, count);
    }

    @Test
    public void testWithOnlyWhiteSpaceText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count(" ");
        assertEquals(0L, count);
    }

    @Test
    public void testWithDuplicateSpacesText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count("text  text");
        assertEquals(2L, count);
    }

    @Test
    public void testWithFirstSpaceText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count(" text text");
        assertEquals(2L, count);
    }

    @Test
    public void testWithNotValidText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count("text text&");
        assertEquals(1L, count);
    }

    @Test
    public void testWithLowerUpperCaseText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count("tExT");
        assertEquals(1L, count);
    }

    @Test
    public void testWithNoOnlyAzText() {
        WordCounter wordCounter = new WordCounterImpl();
        long count = wordCounter.count("tExT0 tExT. *tExT0 tE_xT");
        assertEquals(0L, count);
    }

}