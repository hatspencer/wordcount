import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Foo {

    public static void main(String[] args) {

        String[] words;

        WordProvider wp = new WordProvider();

        if (args.length >= 1) {
            String path = args[0];
            List<String> input = FileProvider.getInputFromFile(path);
            words = wp.getWords(input);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter text: ");
            String text = scanner.nextLine();

            words = wp.getWords(text);
        }

        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

        List<String> stopwords = FileProvider.getInputFromResourceFile("stopwords.txt");

        List<String> matching = Filter.filterWords(pattern.asPredicate().and((word) -> !stopwords.contains(word)), words);

        System.out.print("Number of words: ");
        System.out.println(matching.size());

    }
}
