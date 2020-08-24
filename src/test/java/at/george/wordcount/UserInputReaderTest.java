package at.george.wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputReaderTest {

    public static final String PATH_TO_WRONG_NAME_TXT = "wrongName.txt";
    public static final String PATH_TO_MYTEXT_TXT = "test_mytext.txt";

    @Test
    void getWordsFromFile() {
        String actual = UserInputReader.getWordsFromFile(PATH_TO_MYTEXT_TXT);
        String expected = "This is my text and a next line";

        assertEquals(expected, actual);
    }

    @Test
    void countFromFileWhenFileIsNotFound() {
        assertThrows(NullPointerException.class, () -> UserInputReader.getWordsFromFile(PATH_TO_WRONG_NAME_TXT));
    }
}
