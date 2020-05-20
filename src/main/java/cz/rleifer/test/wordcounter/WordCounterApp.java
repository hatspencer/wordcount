package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.IOAccess;
import cz.rleifer.test.wordcounter.core.IOAccessImpl;
import cz.rleifer.test.wordcounter.core.WordCounter;
import cz.rleifer.test.wordcounter.core.WordCounterImpl;

public class WordCounterApp {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounterImpl();
        IOAccess ioAccess = new IOAccessImpl();
        ioAccess.printInput("Enter text:");
        String usersInput = ioAccess.readInput();
        int wordCount = wordCounter.countWords(usersInput);
        ioAccess.printInput("Number of words: " + wordCount);
    }
}
