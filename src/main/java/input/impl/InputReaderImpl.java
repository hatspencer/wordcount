package input.impl;

import java.util.Scanner;

import input.InputReader;

public class InputReaderImpl implements InputReader {

    private final Scanner scanner;

    public InputReaderImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInputLine() {
        return scanner.nextLine();
    }
}
