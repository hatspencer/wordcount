package at.erste;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class SplitWordCounterUtil {

    public static final Pattern PATTERN_TO_MATCH = Pattern.compile("[a-z]+");

    public static Integer countWords(String sentence) {
        int result = 0;
        if (sentence == null) {
            return result;
        }

        String lowered = sentence.toLowerCase();
        lowered = lowered.replaceAll(" ", "");
        Matcher matcher = PATTERN_TO_MATCH.matcher(lowered);
        while (matcher.find()) {
            String group = matcher.group();
            result++;
        }
        return result;
    }

}
