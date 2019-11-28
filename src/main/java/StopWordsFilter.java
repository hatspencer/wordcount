import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
class StopWordsFilter {

    private final Predicate<String> notAStopWord;

    StopWordsFilter(Set<String> stopWords) {
        this.notAStopWord = word -> !stopWords.contains(word);
    }

    List<String> filter(List<String> toFilter) {
        return toFilter.stream()
            .filter(notAStopWord)
            .collect(Collectors.toList());
    }
}
