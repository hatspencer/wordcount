package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.InputStringHandler;

import java.io.InputStream;
import java.util.Optional;
import java.util.Scanner;

public class StandardInputHandlerImpl implements InputStringHandler {
    private  Scanner scanner;
    private String currentLine = null;
    private int numberReadLines = 0;
    public StandardInputHandlerImpl(InputStream inputStream) {
        this.scanner =  new Scanner(inputStream);;
    }

    public Optional<String> readLine() {
        return Optional.ofNullable(currentLine);
    }

    public boolean next() {
        if (numberReadLines == 0) {
            currentLine = scanner.nextLine();
            numberReadLines++;
            return true;
        } else return false;
    }
}
