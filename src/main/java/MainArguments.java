import java.util.Optional;

public class MainArguments {
    Optional<String> filePath = Optional.empty();
    boolean outputIndex;

    public static MainArguments createFromArgsArray(String[] args) {
        MainArguments mainArguments = new MainArguments();
        for (String arg : args){
            if (arg.equals("-index")) {
                mainArguments.outputIndex = true;
            } else {
                mainArguments.filePath = Optional.of(arg);
            }
        }
        return mainArguments;
    }
}
