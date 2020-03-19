import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
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

        List<String> stopwords = getStopWordsFromResourceFile("stopwords.txt");

        List<String> matching = Filter.filterWords(pattern.asPredicate().and((word) -> !stopwords.contains(word)), words);

        System.out.print("Number of words: ");
        System.out.println(matching.size());

    }

    private static List<String> getStopWordsFromResourceFile(String resource) {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        try (Stream<String> words = Files.lines(Paths.get(classloader.getResource(resource).getPath()))) {
            return words.collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
