package input.impl;

import java.util.Scanner;

import input.UserInputReader;

public class StdInUserInputReaderImpl implements UserInputReader {

    @Override
    public String getInputLine() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
