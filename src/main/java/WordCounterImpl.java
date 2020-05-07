import java.util.Arrays;

public class WordCounterImpl implements WordCounter {

    @Override
    public long count(String text) {
        if (text == null) {
            return 0;
        }

        String[] splitText = text.split("\\s+");
        return Arrays.stream(splitText)
                .filter(this::isNotBlank)
                .filter(this::hasOnlyAzChars)
                .count();
    }

    private boolean isNotBlank(String str) {
        return !str.isEmpty() && !str.matches("\\s+");
    }

    private boolean hasOnlyAzChars(String str) {
        return str.matches("([a-z]|[A-Z])+");
    }
}
