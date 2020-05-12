package at.george.interview.domain;

public class WordCounter {

    public void printCountedWords(IO io) {
        int wordCount = countWords(io.readTextInput());
        io.writeTextOutput("Number of words: " + wordCount);
    }

    int countWords(String inputText) {

        return 0;
    }

}
