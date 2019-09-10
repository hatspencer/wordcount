import java.util.Scanner;

public class WordCountApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.next();
    }
    public static int countWordsInText(String input){
        String[] wordsInInput = input.split(" ");
        int countOfWords = 0;
        for (String s : wordsInInput) {
            if (s.matches("[A-z]+")) countOfWords++;
        }
        return countOfWords;
    }
}
