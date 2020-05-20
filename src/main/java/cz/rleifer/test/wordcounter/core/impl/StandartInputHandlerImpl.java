package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.InputStringHandler;

import java.io.InputStream;
import java.util.Scanner;

public class StandartInputHandlerImpl implements InputStringHandler {
    private  Scanner scanner;

    public StandartInputHandlerImpl(InputStream inputStream) {
        this.scanner =  new Scanner(inputStream);;
    }

    public String readInput() {
        return scanner.nextLine();
    }

    public boolean hasNext() {
        return scanner.hasNextLine();
    }
}
