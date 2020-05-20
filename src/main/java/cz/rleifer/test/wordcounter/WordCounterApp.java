package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.IOStringHandler;
import cz.rleifer.test.wordcounter.core.IOStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.WordCounter;
import cz.rleifer.test.wordcounter.core.WordCounterImpl;

public class WordCounterApp {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounterImpl();
        IOStringHandler ioStringHandler = new IOStringHandlerImpl(System.in, System.out);
        ioStringHandler.printInput("Enter text:");
        String usersInput = ioStringHandler.readInput();
        int wordCount = wordCounter.countWords(usersInput);
        ioStringHandler.printInput("Number of words: " + wordCount);
    }
}
