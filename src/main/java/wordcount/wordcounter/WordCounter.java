package wordcount.wordcounter;

import wordcount.stopwords.StopWords;

import java.util.regex.Pattern;

public class WordCounter {

    private static final String WORD_PATTERN = "^[a-zA-Z]+$";

    public static int getWordsCount(String [] inputArray, StopWords stopWords) {
        if (inputArray == null) {
            return 0;
        }

        int words = 0;
        for(String word : inputArray ) {
//            System.out.println("("+word+")");
            if (Pattern.compile(WORD_PATTERN).matcher(word).find()) {
                if (!stopWords.isStopWord(word)) {
                    words = words + 1;
                }
            }
        }

        return words;
    }

}