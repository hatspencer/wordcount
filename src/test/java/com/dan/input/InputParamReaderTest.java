package com.dan.input;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputParamReaderTest {

    @Test
    public void when_valid_dictionaryPath_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt",
                "-index", "-dictionaryPath=src/test/resources/dictionary.txt" };

        Input input = readInput(inputArgs);

        assertInput(input, true, true, true);
    }

    @Test
    public void when_invalid_dictionaryPath_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt",
                "-index", "-notdictionary=dictionary.txt" };

        Input input = readInput(inputArgs);

        assertInput(input, true, true, false);
    }

    @Test
    public void when_valid_text_path_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt" };

        Input input = readInput(inputArgs);

        assertInput(input, true, false, false);
    }

    @Test
    public void when_valid_text_path_and_index_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "-index", "src/test/resources/mytext.txt" };

        Input input = readInput(inputArgs);

        assertInput(input, true, true, false);
    }

    @Test
    public void when_valid_text_path_and_invalid_param_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "-param", "src/test/resources/mytext.txt" };

        Input input = readInput(inputArgs);

        assertInput(input, true, false, false);
    }

    private Input readInput(String[] inputArgs) {
        InputParamReader inputParamReader = new InputParamReader(inputArgs);
        return inputParamReader.readInput();
    }

    public void assertInput(Input input, boolean hasText, boolean hasIndex, boolean hasDictionary) {
        assertEquals(hasText, input.hasText());
        assertEquals(hasIndex, input.hasIndex());
        assertEquals(hasDictionary, input.hasDictionary());
    }

}