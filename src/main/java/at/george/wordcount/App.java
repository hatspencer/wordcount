package at.george.wordcount;

import java.util.Objects;

public class App {

    public static void main(String[] args) {
        final int count;
        final WordCountService service = new WordCountService();

        boolean hasCommandLineOneArgument = Objects.nonNull(args) && args.length == 1;

        if (hasCommandLineOneArgument) {
            count = service.countFromPath(args[0]);
        } else {
            final UserInputReader userInputReader = new UserInputReader();
            final String userInput = userInputReader.readInput();
            count = service.count(userInput);
        }
        System.out.println("Number of words: " + count);
    }
}
