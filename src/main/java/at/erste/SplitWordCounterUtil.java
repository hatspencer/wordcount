package at.erste;

import java.util.List;
import java.util.regex.Pattern;


public final class SplitWordCounterUtil {

    private static final Pattern ONLY_ALPHABET = Pattern.compile("[a-zA-Z]+");

    private static StopWordsProvider stopWordsProvider;

    private static List<String> stopWords = null;

    private SplitWordCounterUtil() {
        //Hide default constructor for UTIL class
    }

    public static void setStopWordsProvider(StopWordsProvider stopWordsProvider) {
        SplitWordCounterUtil.stopWordsProvider = stopWordsProvider;
    }

    public static Integer countWords(String sentence) {
        int result = 0;
        if (sentence != null) {
            String[] splits = sentence.split(" ");
            for (String split : splits) {
                boolean matches = ONLY_ALPHABET.matcher(split).matches();
                if (matches) {
                    String lowerCasedSplit = split.toLowerCase();
                    if (!getLowerCardStopWords().contains(lowerCasedSplit)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static List<String> getLowerCardStopWords() {
        return stopWordsProvider.getLowerCardStopWords();
    }

}
