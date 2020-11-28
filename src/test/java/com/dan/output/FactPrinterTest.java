package com.dan.output;

import com.dan.input.Input;
import com.dan.io.SystemIOTest;
import org.junit.Test;

public class FactPrinterTest extends SystemIOTest {

    @Test
    public void when_text_file_then_prints_correct_output() {
        final Input input = Input.builder()
                .withTextFile("src/test/resources/mytext.txt")
                .build();

        print(input);

        assertSystemOut(outputStreamCaptor, "Number of words: 4, unique: 4, average word length: 4.25 characters");
    }

    @Test
    public void when_user_input_then_correct_output() {
        final Input input = Input.builder()
                .withTextContent("Really nice")
                .build();

        print(input);

        assertSystemOut(outputStreamCaptor, "Number of words: 2, unique: 2, average word length: 5.00 characters");
    }

    private void print(Input input) {
        FactPrinter factPrinter = new FactPrinter(input);
        factPrinter.print();
    }

}