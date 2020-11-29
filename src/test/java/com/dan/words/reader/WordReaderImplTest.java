package com.dan.words.reader;

import com.dan.stopwords.StopWords;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class WordReaderImplTest {

    private final StopWords stopWords = StopWords.fromWords("the", "a", "on", "off");
    private final WordReaderImpl wordReader = new WordReaderImpl(stopWords);

    @Test
    public void when_valid_words_then_returns_correct_stream() {
        final String input = "x y z";

        Stream<String> wordStream = wordReader.readWords(input);

        assertStream(wordStream, 3, "x", "y", "z");
    }

    @Test
    public void when_iter_1_input_then_returns_correct_stream() {
        String input = "Mary had a little lamb";

        Stream<String> wordStream = wordReader.readWords(input);

        assertStream(wordStream, 4, "Mary", "had", "little", "lamb");
    }

    @Test
    public void when_iter_4_input_then_returns_correct_stream() {
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";

        Stream<String> wordStream = wordReader.readWords(input);

        assertStream(wordStream, 7, "Humpty-Dumpty", "sat", "wall", "Humpty-Dumpty",
                "had", "great", "fall");
    }

    @Test
    public void when_special_chars_then_filtered_out() {
        String input = "%$!";

        Stream<String> wordStream = wordReader.readWords(input);

        assertEmpty(wordStream);
    }

    @Test
    public void when_numbers_then_filtered_out() {
        String input = "321";

        Stream<String> wordStream = wordReader.readWords(input);

        assertEmpty(wordStream);
    }

    @Test
    public void when_stopword_then_filtered_out() {
        String input = "a";

        Stream<String> wordStream = wordReader.readWords(input);

        assertEmpty(wordStream);
    }

    @Test
    public void when_stopword_with_dot_then_filtered_out() {
        String input = "a.";

        Stream<String> wordStream = wordReader.readWords(input);

        assertEmpty(wordStream);
    }

    @Test
    public void when_blank_string_then_filtered_out() {
        String input = "   ";

        Stream<String> wordStream = wordReader.readWords(input);

        assertEmpty(wordStream);
    }

    @Test
    public void when_empty_string_then_filtered_out() {
        String input = "";

        Stream<String> wordStream = wordReader.readWords(input);

        assertEmpty(wordStream);
    }

    @Test
    public void when_null_then_filtered_out() {
        String input = null;

        Stream<String> wordStream = wordReader.readWords(input);

        assertEmpty(wordStream);
    }

    public void assertEmpty(Stream<String> stream) {
        assertEquals(0, stream.count());
    }

    public void assertStream(Stream<String> stream, int size, String... expectedWords) {
        List<String> outputWords = stream.collect(Collectors.toList());

        assertEquals(size, outputWords.size());

        for (int i = 0; i < expectedWords.length; i++) {
            assertEquals(expectedWords[i], outputWords.get(i));
        }
    }

}