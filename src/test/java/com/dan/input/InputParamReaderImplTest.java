package com.dan.input;

import com.dan.testutil.SystemInMock;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class InputParamReaderImplTest {

    @Test
    public void when_file_input_then_returns_contents_correctly() {
        String[] inputArgs = new String[] { "src/test/resources/mytext.txt" };

        InputParamReader inputParamReader = new InputParamReaderImpl();
        String output = inputParamReader.readInput(inputArgs);

        String expectedFileContents = "Mary had\r\n" +
                " \r\n" +
                "a little\r\n" +
                " \r\n" +
                "lamb";
        assertEquals(expectedFileContents, output);
    }

    @Test
    public void when_nofile_input_then_reads_from_system_in() {
        String[] inputArgs = new String[] { };

        String input = "System input";
        SystemInMock.mockSystemIn(input);

        InputParamReader inputParamReader = new InputParamReaderImpl();
        String output = inputParamReader.readInput(inputArgs);

        assertEquals(input, output);
    }

}