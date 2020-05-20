package cz.rleifer.test.wordcounter.core;

import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCounterImpl implements WordCounter {

    private Pattern pattern = Pattern.compile("[a-zA-Z]");

    public int countWords(String input) {
        int wordCount = 0;
        Scanner scanner = new Scanner(input);
        while (scanner.hasNext(pattern)) wordCount++;
        return wordCount;
    }
}
