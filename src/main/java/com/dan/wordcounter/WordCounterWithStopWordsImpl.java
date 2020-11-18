package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import com.dan.words.WordMatcher;

import static com.dan.wordcounter.streamoperation.DotRemover.removeDots;
import static com.dan.wordcounter.streamoperation.InputSplitter.splitInput;
import static com.dan.wordcounter.streamoperation.WordFilter.isValidWord;

public class WordCounterWithStopWordsImpl implements WordCounter {

    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    private StopWords stopWords;
    private WordMatcher wordMatcher;

    public WordCounterWithStopWordsImpl() {
        this(StopWords.fromFile(STOPWORDS_FILE_PATH));
    }

    WordCounterWithStopWordsImpl(StopWords stopWords) {
        this.stopWords = stopWords;
        this.wordMatcher = WordMatcher.forPattern("[a-zA-Z]+\\.?");
    }

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        Long count = splitInput(input)
                .map(removeDots())
                .filter(isValidWord(wordMatcher, stopWords))
                .count();

        return count.intValue();
    }

}
