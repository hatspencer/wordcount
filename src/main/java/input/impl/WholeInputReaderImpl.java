package input.impl;

import java.util.ArrayList;
import java.util.List;

import input.InputReader;
import input.WholeInputReader;

public class WholeInputReaderImpl implements WholeInputReader {

    private final InputReader inputReader;

    public WholeInputReaderImpl(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @Override
    public List<String> readLines() {
        List<String> lines = new ArrayList<>();
        while (inputReader.hasNewLine()) {
            String line = inputReader.getInputLine();
            lines.add(line);
        }

        return lines;
    }
}
