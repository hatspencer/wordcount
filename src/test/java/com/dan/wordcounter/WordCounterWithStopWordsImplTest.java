package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordCounterWithStopWordsImplTest {

    @Test
    public void when_word_Then_output_is_1() {
        String input = "word";

        StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");
        WordCounter counter = new WordCounterWithStopWordsImpl(stopWords);

        final int countWords = counter.countWords(input);

        assertEquals(1, countWords);
    }

    @Test
    public void when_Mary_had_a_little_lamb_Then_output_is_4() {
        String input = "Mary had a little lamb";

        StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");
        WordCounter counter = new WordCounterWithStopWordsImpl(stopWords);

        final int countWords = counter.countWords(input);

        assertEquals(4, countWords);
    }

}