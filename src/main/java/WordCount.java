import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WordCount {

    public static void main (String[] args) throws IOException {
        System.out.println("Please enter a text:");
        final Scanner scanner = new Scanner(System.in);
        final String words = scanner.nextLine();


        final String pathToStopWords = "/stopwords.txt";
        final String[] wordSet = filterStopWords(
                getWords(words),
                getStopWords(pathToStopWords)
        );

        System.out.println("Number of Words:" + wordSet.length);
    }

    private static String[] getStopWords(String pathToStopWords) throws IOException {
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
