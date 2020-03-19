import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Foo {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = scanner.nextLine();

        String[] words = text.trim().split("\\s+");

        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        List<String> matching = findMatchingWords(pattern, words);

        System.out.print("Number of words: ");
        System.out.println(matching.size());

    }

    public static List<String> findMatchingWords(Pattern pattern, String[] words) {
        return Arrays.stream(words)
                .filter(pattern.asPredicate())
                .collect(Collectors.toList());
    }
}
