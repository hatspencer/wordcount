package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.ApplicationContainer;
import cz.rleifer.test.wordcounter.core.ArgumentResolver;
import cz.rleifer.test.wordcounter.core.InputStringHandler;
import cz.rleifer.test.wordcounter.core.OutputStringHandler;
import cz.rleifer.test.wordcounter.core.impl.InputStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.OutputStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.WordCounterImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static cz.rleifer.test.wordcounter.core.impl.Constants.EMPTY_STRING;

public class WordCounterApp {
    public static void main(String[] args) throws IOException {
        OutputStringHandler outputStringHandler = new OutputStringHandlerImpl(System.out);
        List<String> arguments = Arrays.asList(args);
        InputStream inputStream = null;
        String fileInputTextPath = ArgumentResolver.getInputFilePath(arguments);
        try {
            if (!EMPTY_STRING.equals(fileInputTextPath)) {
                inputStream  = new FileInputStream(new File(fileInputTextPath));
            } else {
                inputStream = System.in;
            }
            InputStringHandler inputStringHandler = new InputStringHandlerImpl(inputStream);
            ApplicationContainer applicationContainer = new ApplicationContainer(inputStringHandler, outputStringHandler, new WordCounterImpl());
            applicationContainer.runApplication(ArgumentResolver.getStopWordFilePath(arguments));
        } catch (IOException ex) {
            outputStringHandler.printInput("Cannot read from input.");
        } finally {
           inputStream.close();
        }

    }
}
