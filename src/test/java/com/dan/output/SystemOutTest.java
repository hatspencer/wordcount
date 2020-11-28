package com.dan.output;

import org.junit.After;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public abstract class SystemOutTest {

    static final String LINE_SEPARATOR = System.lineSeparator();

    final PrintStream standardOut = System.out;
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @After
    public void tearDown() {
        System.setOut(standardOut);
    }

    public static void assertSystemOut(ByteArrayOutputStream outputStreamCaptor, String expectedOutput) {
        String output = outputStreamCaptor.toString().trim();
        assertEquals(expectedOutput, output);
    }

}