import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Foo {

    private List<String> stopWords;

    public static void main(String[] args) {
        new Foo().readStopWords("./src/main/resources/stopwords.txt");
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int wordCount = new Foo().getWordCount(text);
        System.out.println("Number of words: " + wordCount);
    }

    public void readStopWords(String fileName) {
        stopWords = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stopWords.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWordCount(String text) {
        int wordCount = 0;
        String trim = text.trim();
        if (trim.isEmpty())
            return 0;
        String[] split = trim.split("\\s+");
        for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z]*", s);
            if (matches) {
                wordCount++;
            }
        }
        return wordCount;
    }

}
