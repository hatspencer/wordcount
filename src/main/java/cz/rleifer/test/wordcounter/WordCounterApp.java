package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.IOHandler;
import cz.rleifer.test.wordcounter.core.IOHandlerImpl;
import cz.rleifer.test.wordcounter.core.WordCounter;
import cz.rleifer.test.wordcounter.core.WordCounterImpl;

public class WordCounterApp {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounterImpl();
        IOHandler ioHandler = new IOHandlerImpl(System.in, System.out);
        ioHandler.printInput("Enter text:");
        String usersInput = ioHandler.readInput();
        int wordCount = wordCounter.countWords(usersInput);
        ioHandler.printInput("Number of words: " + wordCount);
    }
}
