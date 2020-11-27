package com.dan.words.reader;

import com.dan.stopwords.StopWords;

import java.util.stream.Stream;

import static com.dan.words.reader.DotRemover.removeDots;
import static com.dan.words.reader.InputSplitter.splitInput;
import static com.dan.words.reader.WordFilter.isValidWord;

public class WordReader {

    private WordReader() {
        // prevent init
    }

    public static Stream<String> readWords(String input, StopWords stopWords) {
        Stream<String> wordStream = splitInput(input)
                .map(removeDots());

        return (stopWords != null) ? wordStream.filter(isValidWord(stopWords)) : wordStream;
    }

}
