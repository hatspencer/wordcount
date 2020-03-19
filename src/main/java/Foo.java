import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Foo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = text.trim().split("\\s+");

        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        String[] stopwords = getStopWordsFromFile("resources/stopwords.txt");

        List<String> matching = findMatchingWords(pattern, words);

        System.out.print("Number of words: ");
        System.out.println(matching.size());

    }

    public static List<String> findMatchingWords(Pattern pattern, String[] words) {
        return Arrays.stream(words)
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());
    }

    private static String[] getStopWordsFromFile(String filePath) {
        try (Stream<String> words = Files.lines(Paths.get(filePath))) {
            return words.toArray(String[]::new);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }

}
