import controller.ReaderController;
import dto.inputresolver.CommandLineInputResolverResponseDto;
import reader.TextReader;
import reader.splitter.WordSplitter;
import reader.validator.WordValidator;
import service.ReaderService;
import utils.FileReader;
import utils.inputresolver.CommandLineInputResolver;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final String STOP_WORDS_FILE = "stopwords.txt";

    public static void main(String[] args) {
        final CommandLineInputResolver commandLineInputResolver = new CommandLineInputResolver();
        final CommandLineInputResolverResponseDto commandLineInputResolverResponseDto =
                commandLineInputResolver.resolveCommandLineArguments(args);

        final FileReader fileReader = new FileReader();
        final ReaderController readerController = initializeController(fileReader);

        final String fileTextInput = initializeFileContent(commandLineInputResolverResponseDto.getFileName(), fileReader);
        readerController.readTextAndCountWords(fileTextInput, commandLineInputResolverResponseDto.isWithIndex());
    }

    private static ReaderController initializeController(final FileReader fileReader) {
        List<String> stopWords = fileReader.readFileLines(STOP_WORDS_FILE);

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
            throw new RuntimeException("The filename was invalid: " + fileName);
        }
    }
}