package eu.wordcount;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounterImpl implements WordCounter {

    @Override
    public int countWords(String input) {
        int count = 0;

        if (input != null) {

            Pattern p = Pattern.compile("[a-zA-Z]+");
            Matcher m = p.matcher(input);   // get a matcher object

            while (m.find()) {
                count++;
            }
        }

        return count;
    }
}
