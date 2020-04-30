import java.util.Arrays;
import java.util.Scanner;

public class Foo {

    public static void main(String[] args) {

        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        System.out.println("Number of words: " + countWords(sentence));

        scanner.close();
    }

    public static long countWords(String sentence) {
        String[] words = sentence.split(" ");

        long numWords = Arrays.stream(words)
                .filter(Foo::isWord)
                .count();

        return numWords;
    }

    public static boolean isWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }
        return word.replaceAll("[a-zA-Z]", "").length() == 0;
    }

}
