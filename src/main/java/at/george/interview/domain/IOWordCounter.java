package at.george.interview.domain;

public class IOWordCounter {

    private IO io;

    private WordCounter wordCounter;

    public IOWordCounter(IO io, WordCounter wordCounter) {
        this.io = io;
        this.wordCounter = wordCounter;
    }

    public void printCountedWords() {
        io.printInputQuery("Enter text: ");

        String inputText = io.readTextInputLine();
        long wordCount = wordCounter.countWords(inputText);

        io.printlnResultOutput("Number of words: " + wordCount);
    }
}
