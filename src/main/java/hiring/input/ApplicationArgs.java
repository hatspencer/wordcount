package hiring.input;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApplicationArgs {

    private static final String PRINT_INDEX_ARG_NAME = "-index";

    private final Path inputFilePath;
    private final boolean printIndex;

    public ApplicationArgs(String[] args) {
        Path inputFilePath = null;
        boolean printIndex = false;

        for (String arg : args) {
            if (PRINT_INDEX_ARG_NAME.equals(arg)) {
                printIndex = true;
            } else if (!printIndex) {
                inputFilePath = Paths.get(arg);
            } else {
                throw new IllegalArgumentException("Incorrect number of arguments!");
            }
        }

        this.inputFilePath = inputFilePath;
        this.printIndex = printIndex;
    }

    public Path getInputFilePath() {
        return inputFilePath;
    }

    public boolean isPrintIndex() {
        return printIndex;
    }
}
