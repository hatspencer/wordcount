package com.dan.wordcounter.streamoperation;

import org.junit.Test;

import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class DotRemoverTest {

    @Test
    public void when_a_dot_then_removes_dot() {
        String output = Stream.of("a.").map(DotRemover.removeDots()).findFirst().get();

        assertEquals("a", output);
    }

    @Test
    public void when_abc_then_does_nothing() {
        String output = Stream.of("abc").map(DotRemover.removeDots()).findFirst().get();

        assertEquals("abc", output);
    }

}