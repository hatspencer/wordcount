package cz.rleifer.test.wordcounter.core.impl;

import cz.rleifer.test.wordcounter.core.InputStringHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Optional;

public class FileInputHandlerImpl implements InputStringHandler {
    private String currentLine = null;
    private BufferedReader bufferedReader;

    public FileInputHandlerImpl(Reader reader) {
       this.bufferedReader = new BufferedReader(reader);
    }

    @Override
    public Optional<String> readLine() {
        return Optional.ofNullable(currentLine);
    }

    @Override
    public boolean next() throws IOException {
        currentLine = bufferedReader.readLine();
        return currentLine != null;
    }
}
