package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.InputStringHandler;
import cz.rleifer.test.wordcounter.core.OutputStringHandler;
import cz.rleifer.test.wordcounter.core.StopwordHandler;
import cz.rleifer.test.wordcounter.core.WordCounter;
import cz.rleifer.test.wordcounter.core.impl.InputStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.OutputStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.StopWordHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.WordCounterImpl;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static cz.rleifer.test.wordcounter.core.impl.Constants.STOPWORD_ARGUMENT_NAME;

public class WordCounterApp {
    public static void main(String[] args) throws IOException {
        OutputStringHandler outputStringHandler = new OutputStringHandlerImpl(System.out);
        List<String> arguments = Arrays.asList(args);
        List<String> stopWords = Collections.EMPTY_LIST;
        InputStream inputStream = null;
        File file = new File(arguments.get(0));
        try {
            if (arguments.size() == 3) {
                inputStream  = new FileInputStream(file);
            } else {
                inputStream = System.in;
            }

            if (arguments.contains(STOPWORD_ARGUMENT_NAME)) {
                int indexOfStopwordArg = arguments.indexOf(STOPWORD_ARGUMENT_NAME);
                stopWords = readStopWords(args[indexOfStopwordArg + 1], outputStringHandler);
            }

            InputStringHandler inputStringHandler = new InputStringHandlerImpl(inputStream);
            WordCounter wordCounter = new WordCounterImpl();
            outputStringHandler.printInput("Enter text:");
            String usersInput = inputStringHandler.readInput();
            int wordCount = wordCounter.countWords(usersInput, stopWords);
            outputStringHandler.printInput("Number of words: " + wordCount);
        } catch (IOException ex) {

        } finally {
             inputStream.close();
        }

    }

    private static List<String> readStopWords(String arg, OutputStringHandler outputStringHandler)  {
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
