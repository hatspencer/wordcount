package com.dan.application;

import com.dan.io.SystemIOTest;
import org.junit.Test;

public class ApplicationTest extends SystemIOTest {

    @Test
    public void when_file_input_then_processes_file_input() {
        String[] args = { "src/test/resources/mytext.txt" };

        Application.main(args);

        assertSystemOut(outputStreamCaptor,
                new StringBuilder("Number of words: 4, unique: 4, average word length: 4.25 characters").toString());
    }

    @Test
    public void when_user_then_no_processing() {
        String[] args = { };
        mockSystemIn("ab ab ab" + LINE_SEPARATOR);

        Application.main(args);

        assertSystemOut(outputStreamCaptor,
                new StringBuilder("Enter text: Number of words: 3, unique: 1, average word length: 2.00 characters")
                        .append(LINE_SEPARATOR).append("Enter text:").toString());
    }

    @Test
    public void when_no_input_then_no_processing() {
        String[] args = { };
        mockSystemIn("");

        Application.main(args);

        assertSystemOut(outputStreamCaptor, "Enter text:");
    }

}