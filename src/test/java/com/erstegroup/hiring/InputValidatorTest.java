package com.erstegroup.hiring;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputValidatorTest {

    @Test
    public void validate() {
        String text = "Mary had a little lamb";

        assertTrue(InputValidator.validate(text));
    }

    @Test
    public void validateWithBadCharacter() {
        String text = "Mary # had a little lamb";

        assertFalse(InputValidator.validate(text));
    }
}
