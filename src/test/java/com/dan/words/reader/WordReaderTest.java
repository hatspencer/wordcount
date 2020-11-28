package com.dan.words.reader;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class WordReaderTest {

    @Test
    public void when_a_b_c_then_returns_3() {
        Stream<String> stream = WordReader.splitInput("a b c");

        assertEquals(3, stream.count());
    }

    @Test
    public void when_a_b_dash_c_then_returns_3() {
        Stream<String> stream = WordReader.splitInput("a b-c");

        assertEquals(2, stream.count());
    }

    @Test
    public void when_empty_string_then_returns_0() {
        Stream<String> stream = WordReader.splitInput("");

        assertEquals(0, stream.count());
    }

    @Test
    public void when_null_then_returns_0() {
        Stream<String> stream = WordReader.splitInput(null);

        assertEquals(0, stream.count());
    }

    @Test
    public void when_a_dot_then_removes_dot() {
        String output = Stream.of("a.").map(WordReader.removeDots()).findFirst().get();

        assertEquals("a", output);
    }

    @Test
    public void when_abc_then_does_nothing() {
        String output = Stream.of("abc").map(WordReader.removeDots()).findFirst().get();

        assertEquals("abc", output);
    }

}