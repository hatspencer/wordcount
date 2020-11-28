package com.dan.input;

import com.dan.input.Input.InputBuilder;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInputReader implements InputReader {

    private final Input previousInput;
    private final Scanner scanner;

    public UserInputReader() {
        this(Input.builder().build());
    }

    public UserInputReader(Input previousInput) {
        this.previousInput = previousInput;
        scanner = new Scanner(System.in);
    }

    @Override
    public Input readInput() {
        final InputBuilder builder = Input.builder(previousInput);

        System.out.print("Enter text: ");

        String line = readLine();
        return builder.withTextContent(line).build();
    }

    private String readLine() {
        try {
            return scanner.nextLine().trim();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

}
