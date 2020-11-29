package com.dan.words.reader;

import java.util.stream.Stream;

public interface WordReader {

    Stream<String> readWords(String input);

}
