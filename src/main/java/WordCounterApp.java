import java.util.Scanner;

public class WordCounterApp {

    public static void main(String[] args) {

        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        StopWordReader stopWordReader = new FileStopWordReader();
        WordCounter wordCounter = new WordCounter(stopWordReader);

        System.out.println("Number of words: " + wordCounter.countWords(sentence));

        scanner.close();
    }

}
