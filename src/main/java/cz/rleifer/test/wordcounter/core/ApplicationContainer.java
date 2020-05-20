package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.StopWordHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.WordCounterImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;

public class ApplicationContainer {
    private InputStringHandler inputStringHandler ;
    private OutputStringHandler outputStringHandler;

    public ApplicationContainer(InputStringHandler inputStringHandler, OutputStringHandler outputStringHandler) {
        this.inputStringHandler = inputStringHandler;
        this.outputStringHandler = outputStringHandler;
    }

    public void runApplication(String stopwordPath){
        WordCounter wordCounter = new WordCounterImpl();
        outputStringHandler.printInput("Enter text:");
        String usersInput = inputStringHandler.readInput();
        List<String> stopWords = readStopWords(stopwordPath, outputStringHandler);
        int wordCount = wordCounter.countWords(usersInput, stopWords);
        outputStringHandler.printInput("Number of words: " + wordCount);
    }

    private List<String> readStopWords(String arg, OutputStringHandler outputStringHandler)  {
        File file   = new File(arg);
        StopwordHandler stopwordHandler =  new StopWordHandlerImpl();
        try (Reader reader =  new FileReader(file)) {
            return stopwordHandler.getStopWords(reader);
        } catch (IOException ex) {
            outputStringHandler.printInput("Stop words file cannot be read.");
        }
        return Collections.EMPTY_LIST;
    }
}
