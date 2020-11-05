package at.erste;

import at.erste.api.SentenceInformation;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;


public final class SplitWordCounterUtil {

    private static final Pattern ONLY_ALPHABET = Pattern.compile("[-a-zA-Z\\.]+");

    private static StopWordsProvider stopWordsProvider;

    private SplitWordCounterUtil() {
        //Hide default constructor for UTIL class
    }

    public static void setStopWordsProvider(StopWordsProvider stopWordsProvider) {
        SplitWordCounterUtil.stopWordsProvider = stopWordsProvider;
    }

    public static SentenceInformation getSentenceInformation(String originalSentence) {
        Set<String> uniqueWords = new TreeSet<>(((o1, o2) -> o1.compareToIgnoreCase(o2)));
        int sum = 0;
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
                        uniqueWords.add(split);
                        sum = sum + split.length();
                    }
                }
            }
        }

        Double average = 0d;
        if (result != 0) {
            average =  sum/(double)result;
        }

        return new SentenceInformation(result, uniqueWords.size(), average, uniqueWords);
    }

    public static Integer countWords(String originalSentence) {
        SentenceInformation sentenceInformation = getSentenceInformation(originalSentence);
        return sentenceInformation.getWords();
    }

    private static List<String> getLowerCaseStopWords() {
        return stopWordsProvider.getLowerCaseStopWords();
    }

}
