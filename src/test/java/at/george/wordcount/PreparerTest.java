package at.george.wordcount;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PreparerTest {


//      preparer has stop words

    @Test
    void splitAndCleanInputWithStopWords() {
        final InputPreparer inputPreparer = new InputPreparer(Stream.of("a", "the")
                                                       .collect(toList()));

        List<String> actual = inputPreparer.splitAndCleanInput("this a the")
                .collect(toList());
        List<String> expected = Stream.of("this")
                .collect(toList());

        assertEquals(expected, actual);
    }

    @Test
    void splitAndCleanInputWithoutStopWords() {
        final InputPreparer inputPreparer = new InputPreparer(new ArrayList<>());

        List<String> actual = inputPreparer.splitAndCleanInput("this a the")
                .collect(toList());
        List<String> expected = Stream.of("this", "a", "the")
                .collect(toList());

        assertEquals(expected, actual);
    }

    @Test
    void splitAndCleanInputWithoutStopWordsAndWithoutInput() {
        final InputPreparer inputPreparer = new InputPreparer(new ArrayList<>());

        List<String> actual = inputPreparer.splitAndCleanInput("")
                .collect(toList());
        List<String> expected = new ArrayList<>();

        assertEquals(expected, actual);
    }

    @Test
    void splitAndCleanInputWitStopWordsAndWithoutInput() {
        final InputPreparer inputPreparer = new InputPreparer(Stream.of("a", "the")
                                                       .collect(toList()));

        List<String> actual = inputPreparer.splitAndCleanInput("")
                .collect(toList());
        List<String> expected = new ArrayList<>();

        assertEquals(expected, actual);
    }

    @Test
    void splitAndCleanInputForNotAWord() {
        final InputPreparer inputPreparer = new InputPreparer(new ArrayList<>());

        List<String> actual = inputPreparer.splitAndCleanInput("1 , and1and _ -")
                .collect(toList());
        List<String> expected = new ArrayList<>();

        assertEquals(expected, actual);
    }
}
