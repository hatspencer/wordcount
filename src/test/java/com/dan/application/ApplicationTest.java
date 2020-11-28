package com.dan.application;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import testutil.SystemInMock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;
import static testutil.SystemInMock.assertSystemOut;

public class ApplicationTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void when_called_with_existing_file_then_exits_without_error() {
        String[] args = { "src/test/resources/mytext.txt" };

        Application.main(args);

        assertSystemOut(outputStreamCaptor,
                new StringBuilder("Number of words: 4, unique: 4, average word length: 4.25 characters").toString());
    }

    @Test
    public void when_called_with_existing_file_and_index_then_exits_without_error() {
        String[] args = { "src/test/resources/mytext.txt" , "-index" };

        Application.main(args);

        assertSystemOut(outputStreamCaptor,
                new StringBuilder("Number of words: 4, unique: 4, average word length: 4.25 characters").append(LINE_SEPARATOR)
                        .append("Index:").append(LINE_SEPARATOR)
                        .append("had").append(LINE_SEPARATOR)
                        .append("lamb").append(LINE_SEPARATOR)
                        .append("little").append(LINE_SEPARATOR)
                        .append("Mary").toString());
    }

    @Test
    public void when_provided_file_does_not_exist_then_exits_with_error() {
        String[] args = { "does not exist" };

        try {
            Application.main(args);

            assertTrue("An exception was expected!", false);
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void when_user_input_then_exits_without_error() {
        String[] args = { };

        SystemInMock.mockSystemIn("System input");

        Application.main(args);

        assertSystemOut(outputStreamCaptor,
                new StringBuilder("Enter text: Number of words: 2, unique: 2, average word length: 5.50 characters").toString());
    }

    @Test
    public void when_user_input_with_index_then_exits_without_error() {
        String[] args = { "-index" };

        SystemInMock.mockSystemIn("System input");

        Application.main(args);

        assertSystemOut(outputStreamCaptor,
                new StringBuilder("Enter text: Number of words: 2, unique: 2, average word length: 5.50 characters").append(LINE_SEPARATOR)
                        .append("Index:").append(LINE_SEPARATOR)
                        .append("input").append(LINE_SEPARATOR)
                        .append("System").toString());
    }

}