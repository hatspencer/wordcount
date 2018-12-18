import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordCounter {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = reader.nextLine();
        if (isValidInput(input)) {
            System.out.println("Number of words: " + countWords(input));
        } else {
            System.out.println("Invalid input! Please only enter lower-case, upper-case or whitespace characters only");
        }
    }

    static boolean isValidInput(String input) {
        Pattern alphaAndWhitespaceOnlyPattern = Pattern.compile("^[A-Za-z ]*$");
        Matcher matcher = alphaAndWhitespaceOnlyPattern.matcher(input);
        return matcher.find();
    }

    static long countWords(String text) {
        if (text.isEmpty()) {
            return 0;
        }
        return text.split("\\s+").length;
    }
}
