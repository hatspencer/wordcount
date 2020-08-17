import java.util.Scanner;

public class WordApp {

    private static WordsCounter wordsCounter = new WordsCounter();

    public static void main(String args[]) {
        System.out.println("Enter text:");
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        System.out.println("Number of words: " + wordsCounter.countWords(inputString));
    }
}
