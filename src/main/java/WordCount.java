import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class WordCount {

    public static void main (String[] args) throws IOException {
        System.out.println("Please enter a text:");
        final Scanner scanner = new Scanner(System.in);
        final String words = scanner.nextLine();

        Class clazz = WordCount.class;
        InputStream inputStream = clazz.getResourceAsStream("/stopwords.txt");

        final String[] wordSet = filterStopWords(
                getWordSet(words),
                getWordSet(
                        StreamHelper.readFromInputStream(
                            inputStream
                    )
                )
        );

        System.out.println("Number of Words:" + wordSet.length);
    }

    public static String[] getWordSet(String words) {
        return words.split("\\s");
    }

    public static String[] filterStopWords(String[] wordSet, String[] stopWords) {
        return Arrays.stream(wordSet)
                .filter(word -> Arrays.stream(stopWords).noneMatch(word::equals))
                .toArray(String[]::new);
    }

}
