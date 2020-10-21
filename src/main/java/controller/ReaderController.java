package controller;

import service.ReaderService;

import java.util.Scanner;

public class ReaderController {
    private final ReaderService readerService;
    private final Scanner scanner;

    public ReaderController(final ReaderService readerService, final Scanner scanner) {
        this.readerService = readerService;
        this.scanner = scanner;
    }

    public void readTextAndCountWords() {

    }
}
