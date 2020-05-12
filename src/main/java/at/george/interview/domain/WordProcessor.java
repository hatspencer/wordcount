package at.george.interview.domain;

public class WordProcessor {

    private IO io;

    private WordCounter wordCounter;

    public WordProcessor(IO io, WordCounter wordCounter) {
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
