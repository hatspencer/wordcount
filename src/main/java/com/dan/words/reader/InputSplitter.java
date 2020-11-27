package com.dan.words.reader;

import java.util.Arrays;
import java.util.stream.Stream;

class InputSplitter {

    private InputSplitter() {
        // prevent init
    }

    public static Stream<String> splitInput(String input) {
        return Arrays.stream(input.split("[\\s-]"));
    }

}
