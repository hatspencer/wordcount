package input.impl;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import input.InputReader;

public class OneLineInputReaderImpl implements InputReader {

    private final Scanner scanner;

    public OneLineInputReaderImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }

    @Override
    public List<String> getInputByLines() {
        return Collections.singletonList(getInput());
    }
}
