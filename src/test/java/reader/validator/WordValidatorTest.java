package reader.validator;

import org.junit.Before;
import org.junit.Test;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordValidatorTest {
    private List<String> stopWords;
    private FileReader fileReader;
    private WordValidator wordValidator;

    @Before
    public void initialize() {
        fileReader = new FileReader();
        initializeStopWordsAndHandleException();
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

        stopWords.forEach(stopWord -> assertFalse(wordValidator.isValidWord(stopWord)));
    }

    private void initializeStopWordsAndHandleException() {
        try {
            stopWords = fileReader.readFile("stopwords.txt");
        } catch (IOException ioException) {
            System.out.println("No stopwords file");
            stopWords = new ArrayList<>();
        }
    }
}
