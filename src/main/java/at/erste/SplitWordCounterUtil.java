package at.erste;

import java.util.regex.Pattern;


public final class SplitWordCounterUtil {

    private static final Pattern ONLY_ALPHABET = Pattern.compile("[a-zA-Z]+");

    private SplitWordCounterUtil() {
        //Hide default constructor for UTIL class
    }

    public static Integer countWords(String sentence) {
        int result = 0;
        if (sentence != null) {
            String[] splits = sentence.split(" ");
            for (String split : splits) {
                boolean matches = ONLY_ALPHABET.matcher(split).matches();
                if (matches) {
                    result++;
                }
            }
        }
        return result;
    }

}
