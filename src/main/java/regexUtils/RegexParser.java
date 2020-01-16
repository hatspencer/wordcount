package regexUtils;

public class RegexParser {

    private String userInput;
    private String delimiters = "[\\s.,]";


    public RegexParser(String userInput) {
        this.userInput = userInput;
    }

    public RegexParser(String userInput, String delimiters) {
        this(userInput);
        this.delimiters = delimiters;
    }

    public int countWords() {
        return this.userInput.split(this.delimiters).length;
    }
}
