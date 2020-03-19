package WordsCount;

import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class WordCounter {

    private static final Pattern pattern = Pattern.compile("^[a-zA-Z\\-]+$");

    private List<String> blackList;

    public WordCounter() {

    }

    public WordCounter(List<String> blackList) {
        this.blackList = blackList;
    }

    public int countWords(String[] words) {
        Predicate<String> predicate = this.getPredicate();
        return Filter.filterWords(predicate, words).size();
    }

    public int countUniqueWords(String[] words) {
        Predicate<String> predicate = this.getPredicate();
        return Filter.filterUniqueWords(Filter.filterWords(predicate, words)).size();
    }

    public Double countAverageWordLength(String[] words) {
        Predicate<String> predicate = this.getPredicate();
        List<String> wordsList = Filter.filterWords(predicate, words);
        Double lengthOfAllWords = 0.0;
        for (int i=0; i< wordsList.size(); i++){
            lengthOfAllWords += wordsList.get(i).length();
        }
        return lengthOfAllWords / wordsList.size();
    }

    private Predicate<String> getPredicate() {
        return (blackList != null) ?
                pattern.asPredicate().and((word) -> !blackList.contains(word)) :
                pattern.asPredicate();
    }

}
