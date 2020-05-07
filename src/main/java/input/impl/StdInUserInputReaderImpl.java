package input.impl;

import java.util.Scanner;

import input.InputReader;

public class StdInUserInputReaderImpl implements InputReader {

    @Override
    public String getInputLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
