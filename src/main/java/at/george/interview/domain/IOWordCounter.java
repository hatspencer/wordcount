package at.george.interview.domain;

public class IOWordCounter {

    private IO io;

    private WordCounter wordCounter;

    public IOWordCounter(IO io, WordCounter wordCounter) {
        this.io = io;
        this.wordCounter = wordCounter;
    }

    public void printCountedWords() {
        long wordCount = wordCounter.countWords(io.readTextInput());
        io.writeTextOutput("Number of words: " + wordCount);
    }
}
