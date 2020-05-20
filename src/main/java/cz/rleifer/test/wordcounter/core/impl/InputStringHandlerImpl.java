package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.InputStringHandler;

import java.io.InputStream;
import java.util.Scanner;

public class InputStringHandlerImpl implements InputStringHandler {
    private InputStream inputStream;

    public InputStringHandlerImpl(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String readInput() {
        Scanner scanner = new Scanner(inputStream);
        return scanner.nextLine();
    }
}
