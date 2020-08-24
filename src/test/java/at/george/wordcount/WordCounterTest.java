package at.george.wordcount;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordCounterTest {

    public static final String PATH_TO_WRONG_NAME_TXT = "wrongName.txt";
    public static final String PATH_TO_MYTEXT_TXT = "test_mytext.txt";
    private final WordCounter counter = new WordCounter();

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
            "'wordWithSpaceAfter ', 1",
            "the a word, 1",
    })
    void countWithStopWords(final String text, final int expected) {
        int actual = counter.count(text);

        assertEquals(expected, actual);
    }

    @Test
    void countFromFile() {
        int actual = counter.countFromFile(PATH_TO_MYTEXT_TXT);
        assertEquals(7, actual);
    }

    @Test
    void countFromFileWhenFileIsNotFound() {
        assertThrows(NullPointerException.class, () -> counter.countFromFile(PATH_TO_WRONG_NAME_TXT));
    }
}
