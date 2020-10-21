package utils.inputresolver;

import dto.inputresolver.CommandLineInputResolverResponseDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CommandLineInputResolver {
    private final String dictionaryNamingRegex = "";
    private final List<String> allowedParametersRegularExpressions;

    public CommandLineInputResolver() {
        allowedParametersRegularExpressions = new ArrayList<>();
        allowedParametersRegularExpressions.add("-index");
        allowedParametersRegularExpressions.add("-dictionary=[a-zA-Z]+.txt");
    }

    public CommandLineInputResolverResponseDto resolveCommandLineArguments(final String[] args) {
        final List<String> strings = Arrays.asList(args);
        boolean withIndex = false;
        String fileName = null;
        String dictionaryArgument = null;

        String argument0;
        String argument1;

        switch (strings.size()) {
            case 0:
                break;
            case 1:
                final String argument = strings.get(0);
                if (argument.equals("-index")) {
                    withIndex = true;
                } else {
                    fileName = argument;
                }
                break;
            case 2:
                argument0 = strings.get(0);
                argument1 = strings.get(1);
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
            case 3:
                findArgumentByName(strings, "-index");
                withIndex = true;
                dictionaryArgument = findArgumentByName(strings, dictionaryNamingRegex);
                fileName = strings.stream().filter(candidate -> !candidate.matches("-index") && !candidate.matches(dictionaryNamingRegex))
                        .collect(toList())
                        .get(0);

            default:
                throw new RuntimeException("Program has too many arguments: " + strings);
        }

        return new CommandLineInputResolverResponseDto(fileName, withIndex, dictionaryArgument);
    }

    private String findArgumentByName(final List<String> strings, final String argumentName) {
        final List<String> collectedArguments = strings
                .stream()
                .filter(candidate -> candidate.matches(argumentName))
                .collect(toList());
        if (collectedArguments.size() != 1) {
            throw new RuntimeException("Invalid argument list");
        }

        return collectedArguments
                .get(0);
    }
}
