import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class WordCount {

    public static void main (String[] args) throws IOException {
        final String[] totalWords;

        if (args.length == 0) {
            System.out.println("Please enter a text:");
            final Scanner scanner = new Scanner(System.in);
            final String words = scanner.nextLine();
            totalWords = getWords(words);
        } else {
            String pathToInputFile = args[0];
            totalWords = getWordsFromFile(pathToInputFile);
        }


        final String pathToStopWords = "/stopwords.txt";
        final String[] filteredWords = filterStopWords(
                totalWords,
                getWordsFromFile(pathToStopWords)
        );

        final Set<String> uniqueWords = getSetOfUniueWords(filteredWords);

        System.out.println(
                String.format(
                        "Number of Words: %s. Number of unique words: %s; average word length: %s characters ",
                        filteredWords.length,
                        uniqueWords.size(),
                        getAverageWordLengthOfWords(filteredWords)
                )
        );
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

    private static double getAverageWordLengthOfWords(String[] words) {
        double totalLength = 0;

        for (String word : words) {
            totalLength += word.length();
        }

        return totalLength / words.length;
    }

    private static Set<String> getSetOfUniueWords(String[] words) {
        Set<String> hashSet = new HashSet<>();

        for (String word : words) {
            hashSet.add(word);
        }

        return hashSet;
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