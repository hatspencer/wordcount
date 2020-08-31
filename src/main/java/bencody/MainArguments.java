package bencody;

import java.util.Optional;

public class MainArguments {
    final Optional<String> filePath;
    final boolean outputIndex;

    public MainArguments(Optional<String> filePath, boolean outputIndex) {
        this.filePath = filePath;
        this.outputIndex = outputIndex;
    }

    public static MainArguments createFromArgsArray(String[] args) {
        boolean outputIndex = false;
        String filePath = null;
        for (String arg : args){
            if (arg.equals("-wordIndex")) {
                outputIndex = true;
            } else {
                filePath = arg;
            }
        }
        return new MainArguments(Optional.ofNullable(filePath), outputIndex);
    }


}
