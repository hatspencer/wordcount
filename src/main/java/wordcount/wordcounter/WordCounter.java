package wordcount.wordcounter;

import wordcount.stopwords.StopWords;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WordCounter {

    private static final String WORD_PATTERN = "^([a-zA-Z]+-)?[a-zA-Z]+$";

    public static Statistic getWordsCount(String [] inputArray, StopWords stopWords) {
        if (inputArray == null) {
            return new Statistic(0, 0);
        }

        int words = 0;

        List<String> uniqueWords = new ArrayList<>();

        for(String word : inputArray ) {
//            System.out.println("("+word+")");
            if (Pattern.compile(WORD_PATTERN).matcher(word).find()) {
                if (!stopWords.isStopWord(word)) {
                    words = words + 1;

                    if (!uniqueWords.contains(word)) {
                        uniqueWords.add(word);
                    }

                }
            }
        }

        return new Statistic(words, uniqueWords.size());
    }

}
