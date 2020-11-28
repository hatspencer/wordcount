package com.dan.io;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public abstract class SystemIOTest {

    public static final String LINE_SEPARATOR = System.lineSeparator();

    public final PrintStream standardOut = System.out;
    public final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    public void assertSystemOut(ByteArrayOutputStream outputStreamCaptor, String expectedOutput) {
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expectedOutput, output);
    }

    public void mockSystemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

}