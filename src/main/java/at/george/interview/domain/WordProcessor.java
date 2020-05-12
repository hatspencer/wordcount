package at.george.interview.domain;

public class WordProcessor {

    private IO io;

    private WordCounter wordCounter;

    private UniquenessCalculator uniquenessCalculator;

    public WordProcessor(IO io, WordCounter wordCounter, UniquenessCalculator uniquenessCalculator) {
        this.io = io;
        this.wordCounter = wordCounter;
        this.uniquenessCalculator = uniquenessCalculator;
    }

    public void printCountedWords() {
        io.printInputQuery("Enter text: ");

        String inputText = io.readTextInputLine();
        long wordCount = wordCounter.countWords(inputText);
        long uniqueCount = uniquenessCalculator.getUniqueWords(inputText);

        io.printlnResultOutput("Number of words: " + wordCount + ", unique: " + uniqueCount);
    }
}
