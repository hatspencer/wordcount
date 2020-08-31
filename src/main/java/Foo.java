import java.util.Scanner;
import java.util.regex.Pattern;

public class Foo {

    public static void main(String[] args) {
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int wordCount = 0;
        String[] split = text.split("\\s");

        for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z]*", s);
            if (matches) {
                wordCount++;
            }
        }

        System.out.println("Number of words: " + wordCount);
    }

}
