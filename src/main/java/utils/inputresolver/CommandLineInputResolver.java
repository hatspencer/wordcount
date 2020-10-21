package utils.inputresolver;

import dto.inputresolver.CommandLineInputResolverResponseDto;

import java.util.Arrays;
import java.util.List;

public class CommandLineInputResolver {
    public CommandLineInputResolverResponseDto resolveCommandLineArguments(final String[] args) {
        final List<String> strings = Arrays.asList(args);
        boolean withIndex = false;
        String fileName = null;

        switch (strings.size()) {
            case 0:
                break;
            case 2:
                final String argument0 = strings.get(0);
                final String argument1 = strings.get(1);
                if (argument0.equals("-index")) {
                    withIndex = true;
                    fileName = argument1;
                } else {
                    fileName = argument0;
                    if (!argument1.equals("-index")) {
                        throw new RuntimeException("Invalid argument list !");
                    }
                    withIndex = true;
                }
                break;
            case 1:
                final String argument = strings.get(0);
                if (argument.equals("-index")) {
                    withIndex = true;
                } else {
                    fileName = argument;
                }
                break;
            default:
                throw new RuntimeException("Program has too many arguments: " + strings);
        }

        return new CommandLineInputResolverResponseDto(fileName, withIndex);
    }
}
