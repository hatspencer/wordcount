package bencody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MainArguments arguments = MainArguments.createFromArgsArray(args);

        String inputText = readInput(arguments);

        StopWordReader stopWordReader = new StopWordReader();
        List<String> stopWords = stopWordReader.readStopWords();
        WordCounter wordCounter = new WordCounter(stopWords);
        WordCountStatistics wordCountStatistics = wordCounter.countWords(inputText, arguments.outputIndex);

        generateOutput(arguments, wordCountStatistics);
    }

    private static String readInput(MainArguments arguments) {
        return arguments.filePath.map(Main::readInputFromFile).orElseGet(Main::readInputFromStdIn);
    }

    private static String readInputFromStdIn() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter text:");
        return in.nextLine();
    }

    private static String readInputFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateOutput(MainArguments arguments, WordCountStatistics wordCountStatistics) {
        String output = String.format("Number of words: %d, unique: %d; average word length: %.2f characters",
                wordCountStatistics.totalCount,
                wordCountStatistics.uniqueCount,
                wordCountStatistics.averageWordLength
        );
        System.out.println(output);

        if (arguments.outputIndex) {
            System.out.println("Index:");
            for (String word : wordCountStatistics.wordIndex) {
                System.out.println(word);
            }
        }
    }
}
