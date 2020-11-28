package com.dan.input;

import com.dan.input.Input.InputBuilder;

import java.util.Scanner;

public class InputParamReaderImpl implements InputParamReader {

    private static final String INDEX_PARAM = "-index";
    private static final String DICTIONARY_PARAM = "-dictionaryPath=";

    private boolean hasIndex = false;

    @Override
    public Input readInput(String[] args) {
        Input input = processArguments(args);

        return input.hasText() ? input : readUserInput(input);
    }

    private Input processArguments(String[] args) {
        hasIndex = checkIndex(args);
        InputBuilder inputBuilder = Input.builder();
        if (hasIndex) inputBuilder.withIndex();
        if (args.length > 0) {
            for (String arg : args) {
                processArgument(inputBuilder, arg);

                if (inputBuilder.isComplete()) break;
            }
        }

        return inputBuilder.build();
    }

    private boolean checkIndex(String[] args) {
        for (String arg : args) {
            if (isIndexParam(arg)) return true;
        }

        return false;
    }

    private void processArgument(InputBuilder inputBuilder, String arg) {
        if (hasIndex && isDictionaryPathParam(arg)) {
            String dictionaryPath = arg.replaceFirst(DICTIONARY_PARAM, "");
            inputBuilder.withDictionaryFile(dictionaryPath);
        } else if (isTextFilePath(arg)) {
            inputBuilder.withTextFile(arg);
        }
    }

    private boolean isIndexParam(String arg) {
        return arg.equalsIgnoreCase(INDEX_PARAM);
    }

    private boolean isDictionaryPathParam(String arg) {
        return arg.startsWith(DICTIONARY_PARAM);
    }

    private boolean isTextFilePath(String arg) {
        return !arg.startsWith("-") && arg.endsWith(".txt");
    }

    private Input readUserInput(Input previousInput) {
        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        return Input.builder(previousInput)
                .withTextContent(line)
                .build();
    }

}
