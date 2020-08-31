import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FooTest {
    @Test
    void TestWithFiveWords() {
        assertEquals(5, new WordCountExample().getWordCount("Mary had a little lamb"));
    }

    @Test
    void TestWithFiveWordsAndSpecialCharacter() {
        assertEquals(4, new WordCountExample().getWordCount("Mary had a little lamb."));
    }

    @Test
    void TestWithEmptyString() {
        assertEquals(0, new WordCountExample().getWordCount(""));
    }

    @Test
    void TestWithSingleCharacters() {
        assertEquals(5, new WordCountExample().getWordCount("a b c d e     $     ?"));
    }

    @Test
    void TestWithSingleCharactersAndSpacesAround() {
        assertEquals(5, new WordCountExample().getWordCount("     a b c d e     $     ?    "));
    }
}
