import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public static List<String> filterWords(Predicate<String> predicate, String[] words) {
        return Arrays.stream(words)
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public static Set<String> filterUniqueWords(List<String> words) {
        return new HashSet<>(words);
    }
}
