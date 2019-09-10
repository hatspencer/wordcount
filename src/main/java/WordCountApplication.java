import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordCountApplication {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter text:");
        String input = in.nextLine();
        int numberOfWords = countWordsInText(input);
        System.out.print("Number of words:" + numberOfWords);

    }

    static int countWordsInText(String input) {
        String[] wordsInInput = input.split(" ");
        int countOfWords = 0;
        for (String s : wordsInInput) {
            if (s.toLowerCase().matches("[a-z]+")) countOfWords++;
        }
        return countOfWords;
    }

    static String[] getInvalidWords() {
        List<String> invalidWords = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader("stopwords.txt"))) {
            while ((line = reader.readLine()) != null) {
                invalidWords.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("stopwords.txt not found");
        } catch (IOException ex) {
            System.out.println("Cannot open file");
        }
        return invalidWords.toArray(new String[0]);
    }
}
