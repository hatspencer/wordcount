package at.erste;

import java.util.regex.Pattern;

public final class SplitWordCounterUtil {

    public static final Pattern PATTERN_TO_MATCH = Pattern.compile("[a-z]+");


    private SplitWordCounterUtil() {
        //Hide default constructor for UTIL class
    }

    public static Integer countWords(String sentence) {
        int result = 0;
        if (sentence != null) {
            String lowered = sentence.toLowerCase();
            String[] splits = lowered.split(" ");
            for (String split : splits) {
                boolean matches = PATTERN_TO_MATCH.matcher(split).matches();
                if (matches) {
                    result++;
                }
            }
        }
        return result;
    }

}
