package at.erste;

import java.util.List;
import java.util.regex.Pattern;


public final class SplitWordCounterUtil {

    private static final Pattern ONLY_ALPHABET = Pattern.compile("[a-zA-Z]+");

    private static StopWordsProvider stopWordsProvider;

    private SplitWordCounterUtil() {
        //Hide default constructor for UTIL class
    }

    public static void setStopWordsProvider(StopWordsProvider stopWordsProvider) {
        SplitWordCounterUtil.stopWordsProvider = stopWordsProvider;
    }

    public static Integer countWords(String originalSentence) {
        int result = 0;
        String sentence = originalSentence;
        if (sentence != null) {
            sentence = sentence.replaceAll("\n", "");
            String[] splits = sentence.split(" ");
            for (String split : splits) {
                boolean matches = ONLY_ALPHABET.matcher(split).matches();
                if (matches) {
                    String lowerCasedSplit = split.toLowerCase();
                    if (!getLowerCaseStopWords().contains(lowerCasedSplit)) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    private static List<String> getLowerCaseStopWords() {
        return stopWordsProvider.getLowerCaseStopWords();
    }

}
