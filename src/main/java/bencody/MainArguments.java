package bencody;

import java.util.Optional;

public class MainArguments {

    private static final String ARG_PREFIX = "-";
    private static final String ARG_VALUE_SUFFIX = "=";
    private static final String INDEX_ARG = ARG_PREFIX + "index";
    private static final String DICTIONARY_ARG = ARG_PREFIX + "dictionary" + ARG_VALUE_SUFFIX;

    final Optional<String> inputFilePath;
    final Optional<String> dictionaryFilePath;
    final boolean outputIndex;

    public MainArguments(Optional<String> inputFilePath, Optional<String> dictionaryFilePath, boolean outputIndex) {
        this.inputFilePath = inputFilePath;
        this.dictionaryFilePath = dictionaryFilePath;
        this.outputIndex = outputIndex;
    }

    public static MainArguments createFromArgsArray(String[] args) {
        boolean outputIndex = false;
        String filePath = null;
        String dictionaryFilePath = null;

        for (String arg : args) {
            if (arg.equals(INDEX_ARG)) {
                outputIndex = true;

            } else if (arg.startsWith(DICTIONARY_ARG)) {
                dictionaryFilePath = arg.substring(DICTIONARY_ARG.length());

            } else {
                filePath = arg;
            }
        }
        return new MainArguments(Optional.ofNullable(filePath), Optional.ofNullable(dictionaryFilePath), outputIndex);
    }


}
