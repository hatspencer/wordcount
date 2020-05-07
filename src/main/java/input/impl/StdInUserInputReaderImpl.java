package input.impl;

import java.util.Scanner;

import input.UserInputReader;

public class StdInUserInputReaderImpl implements UserInputReader {

    @Override
    public String getInput() {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter text: ");
        return myObj.nextLine();
    }
}
