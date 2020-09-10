package hiring.input;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationArgs {

    private static final String DICTIONARY_ARG_NAME = "-dictionary=";
    private static final String PRINT_INDEX_ARG_NAME = "-index";

    private final Path inputFilePath;
    private final Path dictionaryFilePath;
    private final boolean printIndex;

    public ApplicationArgs(String[] args) {
        Path inputFilePath = null;
        Path dictionaryFilePath = null;
        boolean printIndex = false;

        for (String arg : args) {
            if (PRINT_INDEX_ARG_NAME.equals(arg)) {
                printIndex = true;
            } else if (arg.startsWith(DICTIONARY_ARG_NAME)) {
                dictionaryFilePath = Paths.get(arg.substring(DICTIONARY_ARG_NAME.length()));
            } else if (inputFilePath != null) {
                throw new IllegalArgumentException("Incorrect number of arguments!");
            } else {
                inputFilePath = Paths.get(arg);
            }
        }

        this.inputFilePath = inputFilePath;
        this.dictionaryFilePath = dictionaryFilePath;
        this.printIndex = printIndex;
    }

    public Path getInputFilePath() {
        return inputFilePath;
    }

    public Path getDictionaryFilePath() {
        return dictionaryFilePath;
    }

    public boolean isPrintIndex() {
        return printIndex;
    }
}
