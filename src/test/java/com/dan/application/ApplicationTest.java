package com.dan.application;

import com.dan.testutil.SystemInMock;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertTrue;

public class ApplicationTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

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

        assertSystemOut("Number of words: 4");
    }

    @Test
    public void when_provided_file_does_not_exist_then_exits_with_error() {
        String[] args = { "   " };

        try {
            Application.main(args);

            assertTrue("An exception was expected!", false);
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }
    }

    @Test
    public void when_user_input_then_exits_without_error() {
        String[] args = {  };

        SystemInMock.mockSystemIn("System input");

        Application.main(args);

        assertSystemOut("Number of words: 2");
    }

    private void assertSystemOut(String expectedOutput) {
        Assert.assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

}