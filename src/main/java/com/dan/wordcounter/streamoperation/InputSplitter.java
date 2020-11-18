package com.dan.wordcounter.streamoperation;

import java.util.Arrays;
import java.util.stream.Stream;

public class InputSplitter {

    private InputSplitter() {
        // prevent init
    }

    public static Stream<String> splitInput(String input) {
        return Arrays.stream(input.split("[\\s-]"));
    }

}
