package reader.validator;

import org.junit.Before;
import org.junit.Test;
import reader.validator.WordValidator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordValidatorTest {
    private WordValidator wordValidator;

    @Before
    public void initialize() {
        wordValidator = new WordValidator();
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
}
