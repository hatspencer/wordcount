import java.util.Scanner;

public class WordCount {

    public static void main (String[] args){
        System.out.println("Please enter a text:");
        Scanner scanner = new Scanner(System.in);

        final String words = scanner.nextLine();
        final String[] wordSet = WordCount.extractWords(words);

        System.out.println("Number of Words:" + wordSet.length);
    }

    private static String[] extractWords(String words) {
        return words.split(" ");
    }
}
