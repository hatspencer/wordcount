package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.InputStringHandler;

import java.io.BufferedReader;
import java.io.Reader;

public class FileInputHandlerImpl implements InputStringHandler {
    private String currentLine = null;
    private BufferedReader bufferedReader;

    public FileInputHandlerImpl(Reader reader) {
       this.bufferedReader = new BufferedReader(reader);
    }

    @Override
    public String readInput() {
        return "";
    }

    @Override
    public boolean hasNext() {
        return true; //TODO to be done.
    }
}
