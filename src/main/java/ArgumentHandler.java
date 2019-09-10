import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgumentHandler {
    private List<String> arguments;
    private boolean isIndexFlagProvided;
    private boolean isDictionaryFlagProvided;
    private boolean isFilenameProvided;
    private String filename;
    private String dictionaryFilename;
    public ArgumentHandler(String[] arguments) {
        this.arguments = new ArrayList<>(Arrays.asList(arguments));
        processArguments();
    }

    public void processArguments(){
        for (String argument : arguments) {
            if (argument.equals("-index")) isIndexFlagProvided = true;
            else if (argument.contains("-dictionary")) {
                isDictionaryFlagProvided = true;
                dictionaryFilename = argument.split("=")[1];
            } else {
                isFilenameProvided = true;
                filename = argument;
            }
        }
    }

    public boolean isIndexFlagProvided() {
        return isIndexFlagProvided;
    }

    public boolean isFilenameProvided() {
        return isFilenameProvided;
    }

    public String getFilename() {
        return filename;
    }

    public boolean isDictionaryFlagProvided() {
        return isDictionaryFlagProvided;
    }

    public String getDictionaryFilename() {
        return dictionaryFilename;
    }
}
