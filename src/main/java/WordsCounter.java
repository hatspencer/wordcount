import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordsCounter {

    private static final String SPACE_REGEX = "\\s+";
    private static final String WORD_REGEX = "[a-zA-Z]+\\.?";

    public int countWords(String input, List<String> stopWords) {
        String[] splittedGroups = input.split(SPACE_REGEX);
        List<String> parsedStopWords = parseStopWords(stopWords);
        int wordCnt = 0;
        for (String splittedGroup : splittedGroups) {
            if (splittedGroup.matches(WORD_REGEX) && !parsedStopWords.contains(splittedGroup)) {
                wordCnt++;
            }
        }
        return wordCnt;
    }

    private List<String> parseStopWords(List<String> inputList) {
        List<String> parsedWordList = new ArrayList<>();
        for (String line : inputList) {
            parsedWordList.addAll(Arrays.asList(line.split(SPACE_REGEX)));
        }
        return parsedWordList;
    }
}
