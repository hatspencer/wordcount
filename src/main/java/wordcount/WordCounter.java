package wordcount;

import java.util.regex.Pattern;

public class WordCounter {

    public static int getWordsCount(String [] inputArray) {
        int words = 0;

        if (inputArray == null) {
            return 0;
        }

        for(String word : inputArray ) {
            System.out.println("("+word+")");
            if (Pattern.compile("^[a-zA-Z]+$").matcher(word).find()) {
                words = words + 1;
            }
        }

        return words;
    }

}
