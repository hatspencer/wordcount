package word.count.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import text.split.TextSplitter;
import word.count.WordCounter;
import word.match.WordMatcher;

public class WordCounterImplTest {

    @Test
    public void testWithEmptyListTextSplitter() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher, textSplitter);
        long count = wordCounter.count("any");
        assertEquals(0L, count);
    }

    @Test
    public void testWithOneItemTextSplitter() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        TextSplitter textSplitter = new TextSplitterOneItemListMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher, textSplitter);
        long count = wordCounter.count("any");
        assertEquals(1L, count);
    }

    @Test
    public void testWithNullText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher, textSplitter);
        long count = wordCounter.count(null);
        assertEquals(0L, count);
    }

    @Test
    public void testWithFalseWordMatcher() {
        WordMatcher wordMatcher = new WordMatcherFalseMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(wordMatcher, textSplitter);
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

    private class TextSplitterEmptyListMock implements TextSplitter {
        @Override 
        public List<String> split(String text) {
            return new ArrayList<>();
        }
    }

    private class TextSplitterOneItemListMock implements TextSplitter {
        @Override
        public List<String> split(String text) {
            List<String> list = new ArrayList<>();
            list.add("word");
            return list;
        }
    }
}