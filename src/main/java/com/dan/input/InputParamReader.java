package com.dan.input;

import com.dan.input.Input.InputBuilder;

public class InputParamReader implements InputReader {

    private static final String INDEX_PARAM = "-index";
    private static final String DICTIONARY_PARAM = "-dictionaryPath=";

    private final String[] args;

    public InputParamReader(String[] args) {
        this.args = args;
    }

    @Override
    public Input readInput() {
        InputBuilder inputBuilder = Input.builder()
                .withIndex(checkIndex(args));

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
        if (inputBuilder.hasIndex() && isDictionaryPathParam(arg)) {
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

}
