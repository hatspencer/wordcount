import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class WordCountApplication {
    public static void main(String[] args) {
        String input;
        if (args.length > 0) {
            String filename = args[0];
            input = getSentenceFromFile(filename);
        } else {
            Scanner in = new Scanner(System.in);
            System.out.print("Enter text:");
            input = in.nextLine();
        }

        int numberOfWords = countWordsInText(input);
        System.out.print("Number of words:" + numberOfWords);

    }

    static String getSentenceFromFile(String filename) {
        String[] lines = getInvalidWords(filename);
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append(" ");
        }
        return builder.toString();
    }

    static int countWordsInText(String input) {
        String[] wordsInInput = input.split(" ");
        int countOfWords = 0;
        List<String> invalidWords = Arrays.asList(getInvalidWords("stopwords.txt"));
        for (String s : wordsInInput) {
            if (!invalidWords.contains(s.toLowerCase()) && s.toLowerCase().matches("[a-z]+")) countOfWords++;
        }
        return countOfWords;
    }

    static String[] getInvalidWords(String filename) {
        List<String> invalidWords = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
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
