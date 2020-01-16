package regexutils;

import consoleprinter.Parser;

import java.util.Arrays;

public class RegexParser implements Parser {

    private String userInput;
    private String delimiters = "[\\s.,]";


    public RegexParser(String userInput) {
        this.userInput = userInput;
    }

    public RegexParser(String userInput, String delimiters) {
        this(userInput);
        this.delimiters = delimiters;
    }

    @Override
    public int countWords() {

        if ("".equals(userInput.trim()))
            return 0;

        String[] splitInput = this.userInput.split(this.delimiters);
        return Long.valueOf(Arrays.stream(splitInput)
                .filter(s -> !"".equals(s))
                .count())
                .intValue();
    }
}
