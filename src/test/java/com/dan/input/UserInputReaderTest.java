package com.dan.input;

import com.dan.io.SystemIOTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserInputReaderTest extends SystemIOTest {

    @Test
    public void when_no_file_input_but_index_then_reads_from_system_in() {
        final String systemInput = "System input";
        mockSystemIn(systemInput);

        Input input = readInput();

        assertEquals(systemInput, input.getTextContents());
    }

    private Input readInput() {
        UserInputReader inputParamReader = new UserInputReader();
        return inputParamReader.readInput();
    }

}