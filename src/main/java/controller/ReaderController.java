package controller;

import exception.ControllerException;
import service.ReaderService;
import utils.FileReader;

import java.io.IOException;
import java.util.Scanner;

public class ReaderController {
    private final ReaderService readerService;
    private final FileReader fileReader;
    private final Scanner scanner;

    public ReaderController(final ReaderService readerService, final Scanner scanner, final FileReader fileReader) {
        this.readerService = readerService;
        this.scanner = scanner;
        this.fileReader = fileReader;
    }

    public void readTextAndCountWords(final String fileName) {
        String userTextInput = readInputStringFromFileOrUserInput(fileName);

        final int wordsInUserInput = readerService.countWordsInText(userTextInput);

        System.out.println("Your text has exactly: " + wordsInUserInput + " words!");
    }

    private String readInputStringFromFileOrUserInput(final String fileName) {
        String userTextInput;

        if (fileName == null || fileName.isEmpty()) {
            System.out.println("No filename was specified so please introduce a text to analyze: ");
            userTextInput = scanner.nextLine();
        } else {
            try {
                userTextInput = fileReader.readWholeFile(fileName);
            } catch (IOException ioException) {
                throw new ControllerException("The file you specified is not correct");
            }
        }

        return userTextInput;
    }
}