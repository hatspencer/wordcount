package controller;

import dto.TextAnalysisResponseDto;
import service.ReaderService;

import java.util.Scanner;

public class ReaderController {
    private final ReaderService readerService;
    private final Scanner scanner;

    public ReaderController(final ReaderService readerService, final Scanner scanner) {
        this.readerService = readerService;
        this.scanner = scanner;
    }

    public void readTextAndCountWords(final String textFromFile) {
        String userTextInput = textFromFile;

        final boolean isTextFromFileNullOrEmpty = textFromFile == null || textFromFile.isEmpty();
        if (isTextFromFileNullOrEmpty) {
            System.out.println("No filename was specified so please introduce a text to analyze: ");
            userTextInput = scanner.nextLine();
        }

        final TextAnalysisResponseDto response = readerService.countWordsInText(userTextInput);
        System.out.println(response);
    }
}