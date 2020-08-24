package at.george.wordcount;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WordCounterTest {

    private WordCounter counter = new WordCounter();

    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "word, 1",
            "word word, 2",
            "word1word word, 1",
            "'word word           wod', 3",
            "'. , 1 / *', 0",
            "'Foo1 Bar! Baz, Baz. word', 1",
            "' wordWithSpaceBefore', 1",
            "'wordWithSpaceAfter ', 1"
    })
    void count(final String text, final int expected) {
        int actual = counter.count(text);

        assertEquals(expected, actual);
    }
}
