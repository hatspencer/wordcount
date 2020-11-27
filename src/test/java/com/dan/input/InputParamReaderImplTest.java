package com.dan.input;

import org.junit.Test;
import testutil.SystemInMock;

import static org.junit.Assert.*;

public class InputParamReaderImplTest {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Test
    public void when_file_input_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt" };

        InputParamReader inputParamReader = new InputParamReaderImpl();
        Input input = inputParamReader.readInput(inputArgs);

        String expectedFileContents = getExpectedFileContents();

        assertEquals(expectedFileContents, input.getText());
        assertNull(input.getParam());
    }

    @Test
    public void when_file_input_and_param_then_returns_correct_input_obj() {
        String[] inputArgs = new String[] { "-param", "src/test/resources/mytext.txt" };

        InputParamReader inputParamReader = new InputParamReaderImpl();
        Input input = inputParamReader.readInput(inputArgs);

        String expectedFileContents = getExpectedFileContents();

        assertEquals(expectedFileContents, input.getText());
        assertEquals("param", input.getParam());
    }

    @Test
    public void when_invalid_file_input_then_throws_exception() {
        String[] inputArgs = new String[] { "does_not_exist" };

        InputParamReader inputParamReader = new InputParamReaderImpl();
        try {
            inputParamReader.readInput(inputArgs);

            assertTrue("An exception was expected!", false);
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void when_no_file_input_but_param_present_then_reads_from_system_in() {
        String[] inputArgs = new String[] { "-param" };

        String consoleInput = "System input";
        SystemInMock.mockSystemIn(consoleInput);

        InputParamReader inputParamReader = new InputParamReaderImpl();
        Input input1 = inputParamReader.readInput(inputArgs);

        assertEquals(consoleInput, input1.getText());
        assertEquals("param", input1.getParam());
    }

    @Test
    public void when_no_file_input_then_reads_from_system_in() {
        String[] inputArgs = new String[] { };

        String consoleInput = "System input";
        SystemInMock.mockSystemIn(consoleInput);

        InputParamReader inputParamReader = new InputParamReaderImpl();
        Input input1 = inputParamReader.readInput(inputArgs);

        assertEquals(consoleInput, input1.getText());
    }

    private String getExpectedFileContents() {
        return new StringBuilder("Mary had").append(LINE_SEPARATOR)
                .append(" ").append(LINE_SEPARATOR)
                .append("a little").append(LINE_SEPARATOR)
                .append(" ").append(LINE_SEPARATOR)
                .append("lamb").toString();
    }

}