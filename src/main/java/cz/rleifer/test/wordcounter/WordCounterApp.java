package cz.rleifer.test.wordcounter;

import cz.rleifer.test.wordcounter.core.ApplicationContainer;
import cz.rleifer.test.wordcounter.core.InputStringHandler;
import cz.rleifer.test.wordcounter.core.OutputStringHandler;
import cz.rleifer.test.wordcounter.core.impl.InputStringHandlerImpl;
import cz.rleifer.test.wordcounter.core.impl.OutputStringHandlerImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static cz.rleifer.test.wordcounter.core.impl.Constants.STOPWORD_ARGUMENT_NAME;

public class WordCounterApp {
    public static void main(String[] args) throws IOException {
        OutputStringHandler outputStringHandler = new OutputStringHandlerImpl(System.out);
        List<String> arguments = Arrays.asList(args);
        InputStream inputStream = null;
        if (arguments.size() == 0) {
            outputStringHandler.printInput("Missing arguments -stopword");
            System.exit(0);
        }
        File file = new File(arguments.get(0));
        try {
            if (arguments.size() == 3) {
                inputStream  = new FileInputStream(file);
            } else {
                inputStream = System.in;
            }
            InputStringHandler inputStringHandler = new InputStringHandlerImpl(inputStream);
            ApplicationContainer applicationContainer = new ApplicationContainer(inputStringHandler, outputStringHandler);
            applicationContainer.runApplication(arguments.get(arguments.indexOf(STOPWORD_ARGUMENT_NAME) + 1));

        } catch (IOException ex) {

        } finally {
             inputStream.close();
        }

    }


}
