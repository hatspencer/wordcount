import java.util.*;

public class WordsCounter {

    private static final String INPUT_STRING_SPLIT_REGEX = "[-\\s]";
    private static final String WORD_REGEX = "[a-zA-Z]+\\.?";

    public ResultModel countWords(String input, List<String> stopWords) {
        String[] splittedGroups = input.split(INPUT_STRING_SPLIT_REGEX);
        List<String> parsedStopWords = parseStopWords(stopWords);
        Set<String> uniqueWords = new HashSet<>();
        Integer wordCnt = 0;
        for (String splittedGroup : splittedGroups) {
            if (splittedGroup.matches(WORD_REGEX) && !parsedStopWords.contains(splittedGroup)) {
                uniqueWords.add(splittedGroup);
                wordCnt++;
            }
        }
        return new ResultModel(wordCnt, uniqueWords.size());
    }

    private List<String> parseStopWords(List<String> inputList) {
        List<String> parsedWordList = new ArrayList<>();
        for (String line : inputList) {
            parsedWordList.addAll(Arrays.asList(line.split(INPUT_STRING_SPLIT_REGEX)));
        }
        return parsedWordList;
    }
}
