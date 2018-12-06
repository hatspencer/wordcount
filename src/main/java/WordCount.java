import java.util.Scanner;

public class WordCount {

    public static void main (String[] args){
        System.out.println("Please enter a text:");
        final Scanner scanner = new Scanner(System.in);
        final String words = scanner.nextLine();

        final String[] wordSet = getWordSet(words);

        System.out.println("Number of Words:" + wordSet.length);
    }

    public static String[] getWordSet(String words) {
        return words.split(" ");
    }

}
