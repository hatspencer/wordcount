package word.count.impl;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordMatcher), textSplitter);
        long count = wordCounter.count("any");
        assertEquals(0L, count);
    }

    @Test
    public void testWithOneItemTextSplitter() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        TextSplitter textSplitter = new TextSplitterExactListMock(Collections.singletonList("any"));
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordMatcher), textSplitter);
        long count = wordCounter.count("any");
        assertEquals(1L, count);
    }

    @Test
    public void testWithNullText() {
        WordMatcher wordMatcher = new WordMatcherTrueMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordMatcher), textSplitter);
        long count = wordCounter.count(null);
        assertEquals(0L, count);
    }

    @Test
    public void testWithFalseWordMatcher() {
        WordMatcher wordMatcher = new WordMatcherFalseMock();
        TextSplitter textSplitter = new TextSplitterEmptyListMock();
        WordCounter wordCounter = new WordCounterImpl(Collections.singleton(wordMatcher), textSplitter);
        long count = wordCounter.count("text text");
        assertEquals(0L, count);
    }

    @Test
    public void testWithMultipleExcludingWordMatchers() {
        WordMatcher wordMatcher1 = new WordMatcherExactWordMock("one");
        WordMatcher wordMatcher2 = new WordMatcherExactWordMock("two");
        TextSplitter textSplitter = new TextSplitterExactListMock(Arrays.asList("one","two","three"));
        WordCounter wordCounter = new WordCounterImpl(Arrays.asList(wordMatcher1, wordMatcher2), textSplitter);
        long count = wordCounter.count("one two three");
        assertEquals(0L, count);
    }

    @Test
    public void testWithMultipleWordMatchers() {
        WordMatcher wordMatcher1 = new WordMatcherExactWordMock("one");
        WordMatcher wordMatcher2 = new WordMatcherExactWordMock("one");
        TextSplitter textSplitter = new TextSplitterExactListMock(Arrays.asList("one","two","three"));
        WordCounter wordCounter = new WordCounterImpl(Arrays.asList(wordMatcher1, wordMatcher2), textSplitter);
        long count = wordCounter.count("one two three");
        assertEquals(1L, count);
    }

    private class WordMatcherExactWordMock implements WordMatcher {

        private final String matchWord;

        public WordMatcherExactWordMock(String matchWord) {
            this.matchWord = matchWord;
        }

        @Override
        public boolean match(String word) {
            return word.equals(matchWord);
        }
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
}