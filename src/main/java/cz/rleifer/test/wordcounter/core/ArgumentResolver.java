package cz.rleifer.test.wordcounter.core;

import java.util.List;

import static cz.rleifer.test.wordcounter.core.impl.Constants.EMPTY_STRING;
import static cz.rleifer.test.wordcounter.core.impl.Constants.STOPWORD_ARGUMENT_NAME;

public class ArgumentResolver {

    public static String getInputFilePath(List<String> arguments) {
        if (arguments.size() == 0) return  EMPTY_STRING;
        if  ((arguments.contains(STOPWORD_ARGUMENT_NAME) &&  arguments.indexOf(STOPWORD_ARGUMENT_NAME) != 0)
                || !arguments.contains(STOPWORD_ARGUMENT_NAME)) {
            return arguments.get(0);
        }
        return EMPTY_STRING;
    }

    public static String getStopWordFilePath(List<String> arguments){
        int indexOfStopWordArgument = -1;
        if  ((indexOfStopWordArgument = arguments.indexOf(STOPWORD_ARGUMENT_NAME)) != -1 && arguments.size() > indexOfStopWordArgument + 1) {
            return arguments.get(indexOfStopWordArgument+1);
        }
        return EMPTY_STRING;
    }
}
