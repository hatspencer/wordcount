import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Filter {

    public static List<String> filterWords(Predicate<String> predicate, String[] words) {
        return Arrays.stream(words)
                .filter(predicate)
                .collect(Collectors.toList());
    }
}
