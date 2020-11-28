package com.dan.words.index;

import com.dan.dictionary.Dictionary;
import com.dan.stopwords.StopWords;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WordIndexCreatorImplTest {

    private final StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");

    @Test
    public void when_phrase_then_returns_correct_order() {
        String input = "Mary had a little lamb";

        Dictionary index = createIndexFor(input);

        assertEquals(4, index.size());
        assertEquals("had", index.get(0));
        assertEquals("lamb", index.get(1));
        assertEquals("little", index.get(2));
        assertEquals("Mary", index.get(3));
    }

    @Test
    public void when_phrase_with_duplicates_then_returns_correct_order_and_no_duplicates() {
        String input = "Marys lamb had a little lamb";

        Dictionary index = createIndexFor(input);

        assertEquals(4, index.size());
        assertEquals("had", index.get(0));
        assertEquals("lamb", index.get(1));
        assertEquals("little", index.get(2));
        assertEquals("Marys", index.get(3));
    }

    @Test
    public void when_phrase_with_mi_then_returns_correct_order() {
        String input = "Mery Mary Lucy Lady";

        Dictionary index = createIndexFor(input);

        assertEquals(4, index.size());
        assertEquals("Lady", index.get(0));
        assertEquals("Lucy", index.get(1));
        assertEquals("Mary", index.get(2));
        assertEquals("Mery", index.get(3));
    }

    @Test
    public void when_blank_string_then_returns_empty_list() {
        String input = "     ";

        Dictionary index = createIndexFor(input);

        assertEquals(0, index.size());
    }

    @Test
    public void when_empty_string_then_returns_empty_list() {
        String input = "";

        Dictionary index = createIndexFor(input);

        assertEquals(0, index.size());
    }

    @Test
    public void when_null_then_returns_empty_list() {
        String input = null;

        Dictionary index = createIndexFor(input);

        assertEquals(0, index.size());
    }

    private Dictionary createIndexFor(String input) {
        WordIndexCreatorImpl indexCreator = new WordIndexCreatorImpl(input, stopWords);
        return indexCreator.createIndex();
    }

}