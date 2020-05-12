package at.george.interview.domain;

import java.util.Arrays;

public class WordCounter {

    public void printCountedWords(IO io) {
        long wordCount = countWords(io.readTextInput());
        io.writeTextOutput("Number of words: " + wordCount);
    }

    long countWords(String inputText) {

        String[] elements = splitToElements(inputText);

        long count = Arrays.asList(elements).stream()
                .filter(element -> element.length() > 0)
                .count();

        return count;
    }

    String[] splitToElements(String inputText) {
        return inputText.split("\\s");
    }

}
