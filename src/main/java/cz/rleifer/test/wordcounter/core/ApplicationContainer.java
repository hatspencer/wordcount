package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.Constants;
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
    private WordCounter wordCounter;

    public ApplicationContainer(InputStringHandler inputStringHandler, OutputStringHandler outputStringHandler, WordCounter wordCounter) {
        this.inputStringHandler = inputStringHandler;
        this.outputStringHandler = outputStringHandler;
        this.wordCounter = wordCounter;
    }

    public void runApplication(String stopWordPath){
        outputStringHandler.printInput("Enter text:");
        String usersInput = inputStringHandler.readInput();
        List<String> stopWords = Constants.EMPTY_STRING.equals(stopWordPath) ? Collections.EMPTY_LIST:
                readStopWords(stopWordPath, outputStringHandler);
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
