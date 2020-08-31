import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class WordCountExample {

    private List<String> stopWords = new ArrayList<>();

    public static void main(String[] args) {
        WordCountExample foo = new WordCountExample();
        System.out.println("Enter text: ");
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int wordCount = foo.getWordCount(text);
        System.out.println("Number of words: " + wordCount);
        int wordCountWithoutStopWords = foo.getWordCountWithoutStopWords(text);
        System.out.println("Number of words without stop words: " + wordCountWithoutStopWords);
    }

    public void readStopWords(String fileName) {
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
        if (trim.isEmpty()) {
            return 0;
        }
        String[] split = trim.split("\\s+");
        for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z]*", s);
            if (matches) {
                wordCount++;
            }
        }
        return wordCount;
    }

    boolean isStopWord(String word) {
        return stopWords.contains(word);
    }

    public int getWordCountWithoutStopWords(String text) {
        readStopWords("./src/main/resources/stopwords.txt");
        int wordCount = 0;
        String trim = text.trim();
        if (trim.isEmpty()) {
            return 0;
        }
        String[] split = trim.split("\\s+");
        for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z]*", s);
            if (matches && !isStopWord(s)) {
                wordCount++;
            }
        }
        return wordCount;
    }

}
