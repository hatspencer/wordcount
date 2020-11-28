package com.dan.output;

import com.dan.input.Input;
import com.dan.io.SystemIOTest;
import org.junit.Test;

public class IndexPrinterTest extends SystemIOTest {

    @Test
    public void when_index_with_dictionary_then_prints_correct_output() {
        final Input input = Input.builder()
                .withTextFile("src/test/resources/mytext.txt")
                .withIndex()
                .withDictionaryFile("src/test/resources/dictionary.txt")
                .build();

        print(input);

        String expectedOutput = new StringBuilder("Index: (unknown: 2)").append(LINE_SEPARATOR)
                .append("had").append(LINE_SEPARATOR)
                .append("lamb*").append(LINE_SEPARATOR)
                .append("little").append(LINE_SEPARATOR)
                .append("Mary*").toString();

        assertSystemOut(outputStreamCaptor, expectedOutput);
    }

    @Test
    public void when_only_index_then_prints_correct_output() {
        final Input input = Input.builder()
                .withTextFile("src/test/resources/mytext.txt")
                .withIndex()
                .build();

        print(input);

        String expectedOutput = new StringBuilder("Index:").append(LINE_SEPARATOR)
                .append("had").append(LINE_SEPARATOR)
                .append("lamb").append(LINE_SEPARATOR)
                .append("little").append(LINE_SEPARATOR)
                .append("Mary").toString();

        assertSystemOut(outputStreamCaptor, expectedOutput);
    }

    @Test
    public void when_no_index_then_prints_correct_output() {
        final Input input = Input.builder()
                .withTextFile("src/test/resources/mytext.txt")
                .build();

        print(input);

        assertSystemOut(outputStreamCaptor, "");
    }

    private void print(Input input) {
        IndexPrinter factPrinter = new IndexPrinter(input);
        factPrinter.print();
    }

}