package com.dan.input;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InputParamReaderImplTest {

    private InputParamReader inputParamReader = new InputParamReaderImpl();

    @Test
    public void when_valid_dictionaryPath_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt",
                "-index", "-dictionaryPath=src/test/resources/dictionary.txt" };

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, true, true);
    }

    @Test
    public void when_invalid_dictionaryPath_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt",
                "-index", "-notdictionary=dictionary.txt" };

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, true, false);
    }

    @Test
    public void when_valid_text_path_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt" };

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, false, false);
    }

    @Test
    public void when_valid_text_path_and_index_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "-index", "src/test/resources/mytext.txt" };

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, true, false);
    }

    @Test
    public void when_valid_text_path_and_invalid_param_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "-param", "src/test/resources/mytext.txt" };

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, false, false);
    }

    @Test
    public void when_no_file_input_but_index_then_reads_from_system_in() {
        String[] inputArgs = new String[] { "-index" };

        mockSystemIn("System input");

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, true, false);
    }

    @Test
    public void when_no_file_input_but_index_with_dict_then_reads_from_system_in() {
        String[] inputArgs = new String[] { "-index", "-dictionaryPath=src/test/resources/dictionary.txt" };

        mockSystemIn("System input");

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, true, true);
    }

    @Test
    public void when_no_file_input_then_reads_from_system_in() {
        String[] inputArgs = new String[] { };

        mockSystemIn("System input");

        Input input = inputParamReader.readInput(inputArgs);

        assertInput(input, true, false, false);
    }

    @Test
    public void when_invalid_file_input_then_throws_exception() {
        String[] inputArgs = new String[] { "does_not_exist" };

        try {
            inputParamReader.readInput(inputArgs);

            assertTrue("An exception was expected!", false);
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    public void assertInput(Input input, boolean hasText, boolean hasIndex, boolean hasDictionary) {
        assertEquals(hasText, input.hasText());
        assertEquals(hasIndex, input.hasIndex());
        assertEquals(hasDictionary, input.hasDictionary());
    }

    public static void mockSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}