import controller.ReaderController;
import reader.TextReader;
import reader.splitter.WordSplitter;
import reader.validator.WordValidator;
import service.ReaderService;
import utils.FileReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        final FileReader fileReader = new FileReader();

        final ReaderController readerController = initializeController(fileReader);

        final String fileName = args.length > 0 ? args[0] : null;
        final String fileTextInput = initializeFileContent(fileName, fileReader);

        readerController.readTextAndCountWords(fileTextInput);
    }

    private static ReaderController initializeController(final FileReader fileReader) {
        List<String> stopWords = initializeStopWords(fileReader);

        final WordSplitter wordSplitter = new WordSplitter();
        final WordValidator wordValidator = new WordValidator(stopWords);
        final TextReader textReader = new TextReader(wordSplitter, wordValidator);

        final ReaderService readerService = new ReaderService(textReader);
        final Scanner systemInScanner = new Scanner(System.in);

        return new ReaderController(readerService, systemInScanner);
    }

    private static String initializeFileContent(final String fileName, final FileReader fileReader) {
        final boolean isStringNullOrEmpty = fileName == null || fileName.isEmpty();
        try {
            return isStringNullOrEmpty ? null : fileReader.readWholeFile(fileName);
        } catch (IOException ioException) {
            throw new RuntimeException("The filename was invalid !");
        }
    }

    private static List<String> initializeStopWords(final FileReader fileReader) {
        List<String> stopWords;

        try {
            stopWords = fileReader.readFileLines(STOP_WORDS_FILE);
        } catch (IOException ioException) {
            System.out.println("Invalid stopwords file, assuming there are no stopwords");
            stopWords = new ArrayList<>();
        }
        return stopWords;
    }
}