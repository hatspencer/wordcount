import java.util.*;

public class WordsCounter {

    private static final String INPUT_STRING_SPLIT_REGEX = "[\\s]";
    private static final String WORD_REGEX = "[a-z-A-Z]+\\.?";

    public ResultModel countWords(String input, List<String> stopWords) {
        String[] splittedGroups = input.split(INPUT_STRING_SPLIT_REGEX);
        List<String> parsedStopWords = parseStopWords(stopWords);
        Set<String> uniqueWords = new HashSet<>();
        Integer wordCnt = 0;
        int charactersCount = 0;
        for (String splittedGroup : splittedGroups) {
            if (splittedGroup.matches(WORD_REGEX) && !parsedStopWords.contains(splittedGroup)) {
                charactersCount += splittedGroup.length();
                uniqueWords.add(splittedGroup);
                wordCnt++;
            }
        }
        double avgWordLength = (double) charactersCount / wordCnt;
        return new ResultModel(wordCnt, uniqueWords.size(), avgWordLength);
    }

    private List<String> parseStopWords(List<String> inputList) {
        List<String> parsedWordList = new ArrayList<>();
        for (String line : inputList) {
            parsedWordList.addAll(Arrays.asList(line.split(INPUT_STRING_SPLIT_REGEX)));
        }
        return parsedWordList;
    }
}
