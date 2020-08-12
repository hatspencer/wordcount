package wordcount.wordcounter;

public class Splitter {

    private static final String DELIMITER_PATTERN = "[\\s.]+";
    
    public static String[] split(String input) {
        if (input.isEmpty()) {
            String[] emptyArray = {};
            return emptyArray;
        }
        return input.split(DELIMITER_PATTERN);
    }
    
}
