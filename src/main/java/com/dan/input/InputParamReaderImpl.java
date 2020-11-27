package com.dan.input;

import com.dan.input.Input.InputBuilder;
import com.dan.util.FileReader;

import java.io.IOException;
import java.util.Scanner;

public class InputParamReaderImpl implements InputParamReader {

    @Override
    public Input readInput(String[] args) {
        Input input = processArguments(args);

        return input.hasText() ? input : readUserInput(input);
    }

    private Input processArguments(String[] args) {
        InputBuilder inputBuilder = Input.builder();
        if (args.length > 0) {
            for (String arg : args) {
                processArgument(inputBuilder, arg);

                if (inputBuilder.isComplete()) break;
            }
        }

        return inputBuilder.build();
    }

    private void processArgument(InputBuilder inputBuilder, String arg) {
        if (isFilePath(arg)) {
            inputBuilder.withText(readFile(arg));
        } else if (isParam(arg)) {
            inputBuilder.withParam(arg.substring(1));
        }
    }

    private boolean isFilePath(String arg) {
        return arg.endsWith(".txt");
    }

    private boolean isParam(String arg) {
        return arg.startsWith("-");
    }

    private String readFile(String filePath) {
        try {
            return FileReader.readFile(filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Input readUserInput(Input previousInput) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return Input.builder(previousInput)
                .withText(line)
                .build();
    }

}
