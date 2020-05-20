package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.IOStringHandler;
import cz.rleifer.test.wordcounter.core.StopwordHandler;
import cz.rleifer.test.wordcounter.core.WordCounter;
import cz.rleifer.test.wordcounter.core.impl.IOStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.StopWordHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.WordCounterImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class WordCounterApp {
    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounterImpl();
        IOStringHandler ioStringHandler = new IOStringHandlerImpl(System.in, System.out);
        List<String> stopWords = readStopWords(args[0], ioStringHandler);
        ioStringHandler.printInput("Enter text:");
        String usersInput = ioStringHandler.readInput();
        int wordCount = wordCounter.countWords(usersInput, stopWords);
        ioStringHandler.printInput("Number of words: " + wordCount);
    }

    private static List<String> readStopWords(String arg, IOStringHandler ioStringHandler)  {
        File file   = new File(arg);
        StopwordHandler stopwordHandler =  new StopWordHandlerImpl();
        try (Reader reader =  new FileReader(file)) {
            return stopwordHandler.getStopWords(reader);
        } catch (IOException ex) {
            ioStringHandler.printInput("Stop words file cannot be read.");
        }
        return Collections.EMPTY_LIST;
    }
}
