import java.util.Scanner;
import java.util.regex.Pattern;

public class Foo {

    public static void main(String[] args) {
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int wordCount = new Foo().getWordCount(text);

        System.out.println("Number of words: " + wordCount);
    }

    public int getWordCount(String text) {
        int wordCount = 0;
        String trim = text.trim();
        if (trim.isEmpty())
            return 0;
        String[] split = trim.split("\\s+");
        for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z]*", s);
            if (matches) {
                wordCount++;
            }
        }
        return wordCount;
    }

}
