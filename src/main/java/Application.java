import sun.misc.ClassLoaderUtil;
import wordcount.WordCounter;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {

    private static final String PROMPT = "Enter text: ";
    private static final String OUTPUT_PREFIX = "Number of words: ";

    public static void main(String[] args) throws IOException {
        System.out.print(PROMPT);
        Scanner userInput = new Scanner(System.in);
        String inputString = userInput.nextLine();
        List<String> stopwords = getStopwords();
        int wordCount = new WordCounter(stopwords).countWordsInUserInput(inputString);
        System.out.println(OUTPUT_PREFIX.concat(String.valueOf(wordCount)));
    }

    public static List<String> getStopwords() throws IOException {
        Path path = FileSystems.getDefault().getPath("stopwords.txt").toAbsolutePath();
        return Files.readAllLines(path);
    }

}
