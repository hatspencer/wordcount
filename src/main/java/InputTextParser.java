import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:tibor@thinkcreatix.com">Tibor Koma</a>
 */
public class InputTextParser {

    public List<String> parse(String inputText) {
        String trimmed = inputText.trim();

        if ("".equals(trimmed)) {
            return Collections.emptyList();
        }

        return Arrays.stream(trimmed.split("\\W+"))
            .filter(token -> token.matches("[a-zA-Z]+"))
            .collect(Collectors.toList());
    }
}
