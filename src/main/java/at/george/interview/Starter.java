package at.george.interview;

import at.george.interview.domain.IOWordCounter;
import at.george.interview.domain.counters.AlphabeticWordCounter;
import at.george.interview.infrastructure.CommandLineIO;

public class Starter {

    public static void main(String[] args) {
        CommandLineIO commandLineIO = new CommandLineIO();
        AlphabeticWordCounter alphabeticWordCounter = new AlphabeticWordCounter();

        new IOWordCounter(commandLineIO, alphabeticWordCounter)
                .printCountedWords();
    }
}
