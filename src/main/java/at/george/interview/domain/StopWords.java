package at.george.interview.domain;

import com.oracle.tools.packager.IOUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;

public final class StopWords {

    private static StopWords instance;

    private List<String> wordList;

    private StopWords(List<String> wordList) {
        this.wordList = wordList;
    }

    public synchronized static StopWords getInstance() {
        if (instance == null) {
            instance = fromFile(new File("src/main/resources/stopwords.txt"));
        }
        return instance;
    }

    public static StopWords fromFile(File file) {
        byte[] bytes = readBytesAndHandleIoErrors(file);

        String wordsAsSingleString = new String(bytes);
        String[] lines = wordsAsSingleString.split("\n");

        return fromList(asList(lines));
    }

    private static byte[] readBytesAndHandleIoErrors(File file) {
        try {
            return IOUtils.readFully(file);
        } catch (IOException e) {
            // would have used logger here
            return new byte[0];
        }
    }

    public static StopWords fromList(List<String> words) {
        return new StopWords(filterValidStopWords(words));
    }

    private static List<String> filterValidStopWords(List<String> words) {
        return words.stream()
                .filter(line -> line.trim().length() > 0)
                .collect(toList());
    }

    public List<String> getWordList() {
        return new ArrayList<>(wordList);
    }

    public boolean isStopWord(String word) {
        return wordList.contains(word);
    }

}
