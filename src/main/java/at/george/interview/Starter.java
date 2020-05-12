package at.george.interview;

import at.george.interview.domain.WordCounter;
import at.george.interview.infrastructure.CommandLineIO;

public class Starter {

    public static void main(String[] args) {
        new WordCounter().printCountedWords(new CommandLineIO());
    }
}
