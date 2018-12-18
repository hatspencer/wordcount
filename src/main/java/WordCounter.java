import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCounter {

    private static final String stopWordsFilePath = "stopwords.txt";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = reader.nextLine();
        if (isValidInput(input)) {
            System.out.println("Number of words: " + countValidWords(input, fetchStopWordsFromPath(stopWordsFilePath)));
        } else {
            System.out.println("Invalid input! Please only enter lower-case, upper-case or whitespace characters only");
        }
    }

    static boolean isValidInput(String input) {
        Pattern alphaAndWhitespaceOnlyPattern = Pattern.compile("^[A-Za-z ]*$");
        Matcher matcher = alphaAndWhitespaceOnlyPattern.matcher(input);
        return matcher.find();
    }

    static long countValidWords(String text) {
        return countValidWords(text, Collections.emptyList());
    }

    static long countValidWords(String text, Collection<String> stopWords) {
        if (text.isEmpty()) {
            return 0;
        }

        return Stream.of(text.split("\\s+"))
                .filter(candidate -> !stopWords.contains(candidate))
                .count();
    }

    static Collection<String> fetchStopWordsFromPath(String path) {
        try {
            return Files.lines(Paths.get(path)).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("StopWords file could not be read at path " + path + "!", e);
        }
    }
}
