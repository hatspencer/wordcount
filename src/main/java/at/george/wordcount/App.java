package at.george.wordcount;

import java.util.Objects;

import static at.george.wordcount.UserInputReader.getWordsFromFile;
import static at.george.wordcount.UserInputReader.readInput;

public class App {

    public static void main(String[] args) {
        final WordCountService service = new WordCountService();
        final String userInput;

        boolean hasCommandLineOneArgument = Objects.nonNull(args) && args.length == 1;
        if (hasCommandLineOneArgument) {
            userInput = getWordsFromFile(args[0]);
        } else {
            userInput = readInput();
        }

        System.out.println("Number of words: " + service.count(userInput));
    }
}
