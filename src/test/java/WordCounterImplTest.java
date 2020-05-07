import static org.junit.Assert.*;

import org.junit.Test;

import word.match.WordMatcher;

public class WordCounterImplTest {

    @Test
    public void test() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count("text");
        assertEquals(1L, count);
    }

    @Test
    public void testWithNullText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count(null);
        assertEquals(0L, count);
    }

    @Test
    public void testWithMultipleWhitespaceTypesText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count("text text\ttext\ntext");
        assertEquals(4L, count);
    }

    @Test
    public void testWithEmptyText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count("");
        assertEquals(0L, count);
    }

    @Test
    public void testWithOnlyWhiteSpaceText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count(" ");
        assertEquals(0L, count);
    }

    @Test
    public void testWithDuplicateSpacesText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count("text  text");
        assertEquals(2L, count);
    }

    @Test
    public void testWithFirstSpaceText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count(" text text");
        assertEquals(2L, count);
    }

    @Test
    public void testWithFalseWordMatcher() {
        WordMatcher wordMatcher = new WordMatcherFalseMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher);
        long count = wordCounter.count("text text");
        assertEquals(0L, count);
    }
    
    private class WordMatcherTrueMock implements WordMatcher {
        @Override 
        public boolean match(String word) {
            return true;
        }
    }

    private class WordMatcherFalseMock implements WordMatcher {
        @Override
        public boolean match(String word) {
            return false;
        }
    }

}