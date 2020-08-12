package wordcount.wordcounter;

import wordcount.stopwords.StopWords;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String WORD_PATTERN = "^([a-zA-Z]+-)?[a-zA-Z]+$";

    public static int AVERAGE_CHARACTERS_PRECISION = 2;

    public static Statistic getWordsCount(String [] inputArray, StopWords stopWords) {
        if (inputArray == null) {
            return new Statistic(0, 0, BigDecimal.ZERO);
        }

        int words = 0;
        long sumOfCharactersInWords = 0;

        List<String> uniqueWords = new ArrayList<>();

        for(String word : inputArray ) {
//            System.out.println("("+word+")");
            if (Pattern.compile(WORD_PATTERN).matcher(word).find()) {
                if (!stopWords.isStopWord(word)) {
                    words = words + 1;
                    sumOfCharactersInWords = sumOfCharactersInWords + word.length();

                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }

                }
            }
        }

        return new Statistic(words, uniqueWords.size(), countAverageCharacters(words, sumOfCharactersInWords));
    }

    private static BigDecimal countAverageCharacters(int words, long sumOfCharactersInWords) {
        if (words == 0) {
            return BigDecimal.ZERO;
        }
        return BigDecimal.valueOf(sumOfCharactersInWords).divide(BigDecimal.valueOf(words), AVERAGE_CHARACTERS_PRECISION, RoundingMode.HALF_UP);
    }

}
