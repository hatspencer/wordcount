package at.george.interview;

import at.george.interview.domain.*;
import at.george.interview.domain.counters.AlphabeticWordCounter;
import at.george.interview.infrastructure.CommandLineIO;
import at.george.interview.infrastructure.FileReaderIO;

import java.io.File;

public class Starter {

    public static void main(String[] args) {
        new Starter().run(args);
    }

    private void run(String[] args) {

        StopWords stopWords = StopWords.getInstance();
        WordFilter wordFilter = new AlphabeticalWordFilter(stopWords);
        AlphabeticWordCounter alphabeticWordCounter = new AlphabeticWordCounter(wordFilter);
        IO io = dispatchToIO(args);

        new WordProcessor(io, alphabeticWordCounter)
                .printCountedWords();
    }

    IO dispatchToIO(String[] args) {
        IO io;

        if (argumentsContainFilename(args)) {
            String fileName = args[0];
            io = new FileReaderIO(new File(fileName));
        } else {
            io = new CommandLineIO();
        }
        return io;
    }

    private boolean argumentsContainFilename(String[] args) {
        return args.length > 0;
    }
}
