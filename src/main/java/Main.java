import controller.ReaderController;
import reader.TextReader;
import reader.splitter.WordSplitter;
import reader.validator.WordValidator;
import service.ReaderService;
import utils.FileReader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final FileReader fileReader = new FileReader();
        final WordSplitter wordSplitter = new WordSplitter();
        final WordValidator wordValidator = new WordValidator(fileReader);
        final TextReader textReader = new TextReader(wordSplitter, wordValidator);

        final ReaderService readerService = new ReaderService(textReader);
        final Scanner systemInScanner = new Scanner(System.in);

        final ReaderController readerController = new ReaderController(readerService, systemInScanner);
        readerController.readTextAndCountWords();
    }
}
