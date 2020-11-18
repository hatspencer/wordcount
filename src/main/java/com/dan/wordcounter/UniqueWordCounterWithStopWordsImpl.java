package com.dan.wordcounter;

import com.dan.stopwords.StopWords;
import com.dan.words.WordMatcher;

import static com.dan.wordcounter.streamoperation.DotRemover.removeDots;
import static com.dan.wordcounter.streamoperation.InputSplitter.splitInput;
import static com.dan.wordcounter.streamoperation.WordFilter.isValidWord;

public class UniqueWordCounterWithStopWordsImpl implements WordCounter {

    private static final String STOPWORDS_FILE_PATH = "stopwords.txt";

    private StopWords stopWords;
    private WordMatcher wordMatcher;

    public UniqueWordCounterWithStopWordsImpl() {
        this(StopWords.fromFile(STOPWORDS_FILE_PATH));
    }

    UniqueWordCounterWithStopWordsImpl(StopWords stopWords) {
        this.stopWords = stopWords;
        this.wordMatcher = WordMatcher.forPattern("[a-zA-Z]+\\.?");
    }

    @Override
    public int countWords(String input) {
        if (input == null) return 0;

        Long count = splitInput(input)
                .map(removeDots())
                .filter(isValidWord(wordMatcher, stopWords))
                .distinct()
                .count();

        return count.intValue();
    }

}
