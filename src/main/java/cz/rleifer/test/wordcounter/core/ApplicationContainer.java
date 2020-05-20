package cz.rleifer.test.wordcounter.core;

import cz.rleifer.test.wordcounter.core.impl.Constants;
import cz.rleifer.test.wordcounter.core.impl.StopWordHandlerImpl;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ApplicationContainer {
    private InputStringHandler inputStringHandler ;
    private OutputStringHandler outputStringHandler;
    private WordCounter wordCounter;

    public ApplicationContainer(InputStringHandler inputStringHandler, OutputStringHandler outputStringHandler, WordCounter wordCounter) {
        this.inputStringHandler = inputStringHandler;
        this.outputStringHandler = outputStringHandler;
        this.wordCounter = wordCounter;
    }

    public void runApplication(String stopWordPath) throws IOException {
        List<String> stopWords = Constants.EMPTY_STRING.equals(stopWordPath) ? Collections.EMPTY_LIST:
                readStopWords(stopWordPath, outputStringHandler);
        int wordCount = 0;
        while (inputStringHandler.next()) {
            Optional<String> usersInput = inputStringHandler.readLine();
            wordCount += wordCounter.countWords(usersInput.get(), stopWords);
        }
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
