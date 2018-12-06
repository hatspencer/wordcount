import java.io.IOException;
import java.util.Arrays;

public class WordCount {

    public static void main (String[] args) throws IOException {
        String pathToInputFile = args[0];

        final String pathToStopWords = "/stopwords.txt";
        final String[] wordSet = filterStopWords(
                getWordsFromFile(pathToInputFile),
                getWordsFromFile(pathToStopWords)
        );

        System.out.println("Number of Words:" + wordSet.length);
    }

    private static String[] getWordsFromFile(String pathToStopWords) throws IOException {
        return getWords(
                StreamHelper.readFromInputStream(
                    FileHelper.getInputStreamOfResource(
                            pathToStopWords
                    )
            )
        );
    }

    public static String[] getWords(String words) {
        return words.split("\\s");
    }

    public static String[] filterStopWords(String[] wordSet, String[] stopWords) {
        return Arrays.stream(wordSet)
                .filter(word -> Arrays.stream(stopWords).noneMatch(word::equals))
                .toArray(String[]::new);
    }

}
