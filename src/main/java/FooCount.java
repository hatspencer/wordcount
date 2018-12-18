import java.util.Scanner;

public class FooCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");

        final String textLine = scanner.nextLine();

        final WordCounter wordCounter = new WordCounter();
        final String[] words = textLine.split(" ");
        final long count = wordCounter.countWords(words);

        System.out.println("Number of words: " + count);
    }
}
