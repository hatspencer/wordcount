package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.ApplicationContainer;
import cz.rleifer.test.wordcounter.core.ArgumentResolver;
import cz.rleifer.test.wordcounter.core.InputStringHandler;
import cz.rleifer.test.wordcounter.core.OutputStringHandler;
import cz.rleifer.test.wordcounter.core.impl.FileInputHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.StandardInputHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.OutputStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.WordCounterImpl;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import static cz.rleifer.test.wordcounter.core.impl.Constants.EMPTY_STRING;

public class WordCounterApp {
    public static void main(String[] args) throws IOException {
        OutputStringHandler outputStringHandler = new OutputStringHandlerImpl(System.out);
        List<String> arguments = Arrays.asList(args);
        FileReader fileReader = null;
        InputStringHandler inputStringHandler = null;
        String fileInputTextPath = ArgumentResolver.getInputFilePath(arguments);
        try {
            if (!EMPTY_STRING.equals(fileInputTextPath)) {
               fileReader = new FileReader (new File(fileInputTextPath));
               inputStringHandler  = new FileInputHandlerImpl(fileReader);
            } else {
               inputStringHandler = new StandardInputHandlerImpl(System.in);
               outputStringHandler.printInput("Enter text:");
            }
            ApplicationContainer applicationContainer = new ApplicationContainer(inputStringHandler, outputStringHandler, new WordCounterImpl());
            applicationContainer.runApplication(ArgumentResolver.getStopWordFilePath(arguments));
        } catch (IOException ex) {
            outputStringHandler.printInput("Cannot read from input.");
        } finally {
           if (fileReader != null) {
               fileReader.close();
           }
        }

    }
}

