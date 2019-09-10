import java.util.Scanner;

public class WordCountApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text:");
        String input = in.nextLine();
        int numberOfWords = countWordsInText(input);
        System.out.print("Number of words:" + numberOfWords);

    }
    static int countWordsInText(String input){
        String[] wordsInInput = input.split(" ");
        int countOfWords = 0;
        for (String s : wordsInInput) {
            if (s.matches("[A-z]+")) countOfWords++;
        }
        return countOfWords;
    }
}
