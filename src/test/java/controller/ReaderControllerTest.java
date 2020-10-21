package controller;

import org.junit.Before;
import org.junit.Test;
import reader.TextReader;
import reader.splitter.WordSplitter;
import reader.validator.WordValidator;
import service.ReaderService;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderControllerTest {
    private ReaderController readerController;

    @Before
    public void initialize() {
        List<String> stopWords = new ArrayList<>();

        final WordSplitter wordSplitter = new WordSplitter();
        final WordValidator wordValidator = new WordValidator(stopWords);
        final TextReader textReader = new TextReader(wordSplitter, wordValidator);

        final ReaderService readerService = new ReaderService(textReader);
        String someMockInput = "Some Mock input";
        final Scanner systemInScanner = new Scanner(new ByteArrayInputStream(someMockInput.getBytes()));

        readerController = new ReaderController(readerService, systemInScanner);
    }

    @Test
    public void testReadTextIfNoFileIsGiven() {
        readerController.readTextAndCountWords(null);
    }
}
