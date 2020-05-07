package word.count.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import text.split.TextSplitter;
import word.count.WordCounter;
import word.filter.WordFilter;
import word.map.WordMapper;

public class WordCounterImplTest {

    @Test
    public void testWithEmptyListTextSplitter() {
        WordFilter wordFilter = new WordFilterTrueMock();
        WordMapper wordMapper = new NoopWordMapperMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordFilter), Collections.singleton(wordMapper), textSplitter, "description");
        long count = wordCounter.count("any");
        assertEquals(0L, count);
    }

    @Test
    public void testWithOneItemTextSplitter() {
        WordFilter wordFilter = new WordFilterTrueMock();
        WordMapper wordMapper = new NoopWordMapperMock();
        TextSplitter textSplitter = new TextSplitterExactListMock(Collections.singletonList("any"));
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordFilter), Collections.singleton(wordMapper), textSplitter, "description");
        long count = wordCounter.count("any");
        assertEquals(1L, count);
    }

    @Test
    public void testWithNullText() {
        WordFilter wordFilter = new WordFilterTrueMock();
        WordMapper wordMapper = new NoopWordMapperMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordFilter), Collections.singleton(wordMapper), textSplitter, "description");
        long count = wordCounter.count(null);
        assertEquals(0L, count);
    }

    @Test
    public void testWithFalseWordMatcher() {
        WordFilter wordFilter = new WordFilterFalseMock();
        WordMapper wordMapper = new NoopWordMapperMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordFilter), Collections.singleton(wordMapper), textSplitter, "description");
        long count = wordCounter.count("text text");
        assertEquals(0L, count);
    }

    @Test
    public void testWithMultipleExcludingWordMatchers() {
        WordFilter wordFilter1 = new WordMatcherExactWordMock("one");
        WordFilter wordFilter2 = new WordMatcherExactWordMock("two");
        WordMapper wordMapper = new NoopWordMapperMock();
        TextSplitter textSplitter = new TextSplitterExactListMock(Arrays.asList("one","two","three"));
        WordCounter wordCounter = new WordCounterImpl(Arrays.asList(wordFilter1, wordFilter2), Collections.singleton(wordMapper), textSplitter, "description");
        long count = wordCounter.count("one two three");
        assertEquals(0L, count);
    }

    @Test
    public void testWithMultipleWordMatchers() {
        WordFilter wordFilter1 = new WordMatcherExactWordMock("one");
        WordFilter wordFilter2 = new WordMatcherExactWordMock("one");
        TextSplitter textSplitter = new TextSplitterExactListMock(Arrays.asList("one","two","three"));
        WordMapper wordMapper = new NoopWordMapperMock();
        WordCounter wordCounter = new WordCounterImpl(Arrays.asList(wordFilter1, wordFilter2), Collections.singleton(wordMapper), textSplitter, "description");
        long count = wordCounter.count("one two three");
        assertEquals(1L, count);
    }

    @Test
    public void testWithMappers() {
        // TODO: write some test which will test mapper usage
    }

    private class WordMatcherExactWordMock implements WordFilter {

        private final String matchWord;

        public WordMatcherExactWordMock(String matchWord) {
            this.matchWord = matchWord;
        }

        @Override
        public boolean filter(String word) {
            return word.equals(matchWord);
        }
    }

    private class WordFilterTrueMock implements WordFilter {
        @Override 
        public boolean filter(String word) {
            return true;
        }
    }

    private class WordFilterFalseMock implements WordFilter {
        @Override
        public boolean filter(String word) {
            return false;
        }
    }

    private class TextSplitterEmptyListMock implements TextSplitter {
        @Override 
        public List<String> split(String text) {
            return new ArrayList<>();
        }
    }

    private class TextSplitterExactListMock implements TextSplitter {

        private final List<String> words;

        public TextSplitterExactListMock(List<String> words) {
            this.words = words;
        }

        @Override
        public List<String> split(String text) {
            return words;
        }
    }

    private class NoopWordMapperMock implements WordMapper {

        @Override
        public String map(String text) {
            return text;
        }
    }
}