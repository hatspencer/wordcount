import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class WordCount {

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Enter Text: ");
            String userInput = reader.readLine();
            System.out.println("Number of words: " + countWordsReturnNumberOfValidWords(userInput));
        } catch (IOException e) {
            System.out.println("Could not process request, please try again");
        }
    }

    // valid word constitutes "[a-zA-Z]+"
    private static long countWordsReturnNumberOfValidWords(String name) {
        List<String> wordList = Arrays.asList(name.trim().split("\\s+"));
        return wordList.stream().filter(word ->  word.matches( "[a-zA-Z]+" )).count();
    }

}
