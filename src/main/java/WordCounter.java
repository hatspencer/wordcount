import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter text: ");
        System.out.println("Number of words: " + countWords(reader.nextLine()));
    }

    private static long countWords(String text) {
        Pattern alphaOnlyPattern = Pattern.compile("\\b[A-Za-z]+\\b");
        Matcher matcher = alphaOnlyPattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }
}
