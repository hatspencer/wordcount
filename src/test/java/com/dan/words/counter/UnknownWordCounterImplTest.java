package com.dan.words.counter;

import com.dan.dictionary.Dictionary;
import com.dan.dictionary.DictionaryBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UnknownWordCounterImplTest {

    @Test
    public void when_two_words_from_index_missing_from_dictionary_returns_2() {
        Dictionary index = DictionaryBuilder.fromWords(true, "Mary", "had", "little", "lamb");
        Dictionary dictionary = DictionaryBuilder.fromWords(false,
                "big", "small", "little", "cat", "dog", "have", "has", "had");

        final int unknownWordCount = countWords(index, dictionary);

        assertEquals(2, unknownWordCount);
    }

    @Test
    public void when_two_words_from_index_missing_from_dictionary_case_sensitive_then_returns_2() {
        Dictionary index = DictionaryBuilder.fromWords(true, "Mary", "HAD", "LITTLE", "lamb");
        Dictionary dictionary = DictionaryBuilder.fromWords(false,
                "big", "small", "little", "cat", "dog", "have", "has", "had");

        final int unknownWordCount = countWords(index, dictionary);

        assertEquals(2, unknownWordCount);
    }

    @Test
    public void when_all_words_known_then_returns_0() {
        Dictionary index = DictionaryBuilder.fromWords(true, "Mary", "had", "little", "lamb");
        Dictionary dictionary = DictionaryBuilder.fromWords(false, "Mary", "had", "little", "lamb");

        final int unknownWordCount = countWords(index, dictionary);

        assertEquals(0, unknownWordCount);
    }

    @Test
    public void when_empty_dictionary_returns_4() {
        Dictionary index = DictionaryBuilder.fromWords(true, "Mary", "had", "little", "lamb");
        Dictionary dictionary = DictionaryBuilder.empty();

        final int unknownWordCount = countWords(index, dictionary);

        assertEquals(index.size(), unknownWordCount);
    }

    private int countWords(Dictionary index, Dictionary dictionary) {
        UnknownWordCounterImpl counter = new UnknownWordCounterImpl(index, dictionary);
        return counter.countWords();
    }

}