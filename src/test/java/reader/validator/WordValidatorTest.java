package reader.validator;

import org.junit.Before;
import org.junit.Test;
import utils.FileReader;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class WordValidatorTest {
    private FileReader fileReader;
    private WordValidator wordValidator;

    @Before
    public void initialize() {
        fileReader = new FileReader();
        wordValidator = new WordValidator(fileReader);
    }

    @Test
    public void testIsValidWord() {
        final String VALID_WORD_ONLY_LOWERCASE = "helllo";
        assertTrue(wordValidator.isValidWord(VALID_WORD_ONLY_LOWERCASE));

        final String VALID_WORD_WITH_UPPERCASE = "Titus";
        assertTrue(wordValidator.isValidWord(VALID_WORD_WITH_UPPERCASE));

        final String INVALID_WORD_WITH_SPACE = "Berni ";
        assertFalse(wordValidator.isValidWord(INVALID_WORD_WITH_SPACE));

        final String INVALID_WORD_WITH_ANOTHER_CHARACTER = "Claus$";
        assertFalse(wordValidator.isValidWord(INVALID_WORD_WITH_ANOTHER_CHARACTER));
    }

    @Test
    public void testReadCountWithStopwordsFile() {
        List<String> stopWords;
        try {
            stopWords = initializeStopWordsAndHandleException();
            stopWords.forEach(stopWord -> assertFalse(wordValidator.isValidWord(stopWord)));
        } catch (IOException ioException) {
            ioException.printStackTrace();
            fail();
        }
    }

    private List<String> initializeStopWordsAndHandleException() throws IOException {
        return fileReader.readFileLines("stopwords.txt");
    }
}
