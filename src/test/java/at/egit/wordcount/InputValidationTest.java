package at.egit.wordcount;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class InputValidationTest {

    private InputValidation inputValidation = new InputValidation();

    @Test
    public void whenInputConsistsOfLetter_thenShouldBeValid() {
        final String input = "word";

        final boolean result = inputValidation.validate(input);

        assertTrue(result);
    }

    @Test
    public void whenInputConsistsOfLetterAndSpace_thenShouldBeValid() {
        final String input = "word world";

        final boolean result = inputValidation.validate(input);

        assertTrue(result);
    }

    @Test
    public void whenInputDoesNotConsistOnlyOfLettersAndSpaces_thenShouldBeInvalid() {
        final String input = "word1";

        final boolean result = inputValidation.validate(input);

        assertFalse(result);
    }
}
