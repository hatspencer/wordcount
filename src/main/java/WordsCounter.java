import java.util.*;
import java.util.stream.Collectors;

public class WordsCounter {

    private static final String INPUT_STRING_SPLIT_REGEX = "[\\s]";
    private static final String WORD_REGEX = "[a-z-A-Z]+\\.?";

    public ResultModel countWords(String input, List<String> stopWords) {
        List<String> parsedStopWords = parseStopWords(stopWords);
        List<String> splittedInput = new ArrayList<>(Arrays.asList(input.split(INPUT_STRING_SPLIT_REGEX)));
        List<String> filteredWordsWithoutStop = getWordsWithoutStop(splittedInput, parsedStopWords);
        Set<String> noDuplicates = new HashSet<>(filteredWordsWithoutStop);

        int charactersCount = 0;
        for (String word : filteredWordsWithoutStop) {
            charactersCount += word.length();
        }

        String avgWordLength = calculateAvgWordLength(filteredWordsWithoutStop, charactersCount);
        return new ResultModel(filteredWordsWithoutStop.size(), noDuplicates.size(), avgWordLength);

    }

    private List<String> parseStopWords(List<String> inputList) {
        List<String> parsedWordList = new ArrayList<>();
        for (String line : inputList) {
            parsedWordList.addAll(Arrays.asList(line.split(INPUT_STRING_SPLIT_REGEX)));
        }
        return parsedWordList;
    }

    private List<String> getWordsWithoutStop(List<String> words, List<String> stopWords) {
        return words.stream()
                .filter(word -> word.matches(WORD_REGEX))
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
    }

    private String calculateAvgWordLength(List<String> words, int charCount) {
        return String.format("%.2f", words.size() == 0 ? 0 : (double) charCount / words.size());
    }
}
