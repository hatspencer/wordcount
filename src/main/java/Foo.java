import java.util.Arrays;
import java.util.Scanner;

public class Foo {

    public static void main(String[] args) {

        System.out.println("Enter text: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        String[] words = sentence.split(" ");

        long numWords = Arrays.stream(words)
                .filter(Foo::isWord)
                .count();

        System.out.println("Number of words: " + numWords);

        scanner.close();
    }

    private static boolean isWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }
        return word.replaceAll("[a-zA-Z]", "").length() == 0;
    }

}
