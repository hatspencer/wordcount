import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class WordCountExample {

    private List<String> stopWords = new ArrayList<>();
    private Map<String, Integer> words = new HashMap<>();

    public static void main(String[] args) {
        WordCountExample wordCountExample = new WordCountExample();
        String text;

        if (args.length > 0 && args[0] != null) {
            text = wordCountExample.readText("./src/main/resources/" + args[0]);
        } else {
            System.out.println("Enter text: ");
            Scanner scanner = new Scanner(System.in);
            text = scanner.nextLine();
        }

        int wordCount = wordCountExample.getWordCountUnique(text);
        int numberOfUniqueWords = wordCountExample.getUniqueWords();
        System.out.println("Number of words: " + wordCount + ", unique: " + numberOfUniqueWords);
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

    public String readText(String fileName) {
        StringBuilder inputText = new StringBuilder();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                inputText.append(line).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return inputText.toString();
    }

    public int getWordCount(String text) {
        int wordCount = 0;
        String trim = text.trim();
        if (trim.isEmpty()) {
            return 0;
        }
        String[] split = trim.split("[\\s+-]");
        for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z-]*\\.?", s);
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
        String[] split = trim.split("[\\s+-]");
            for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z-]*\\.?", s);
            if (matches && !isStopWord(s)) {
                wordCount++;
            }
        }
        return wordCount;
    }
    public int getWordCountUnique(String text) {
        readStopWords("./src/main/resources/stopwords.txt");
        int wordCount = 0;
        String trim = text.trim();
        if (trim.isEmpty()) {
            return 0;
        }
        String[] split = trim.split("[\\s+-]");
        for (String s : split) {
            boolean matches = Pattern.matches("[a-zA-Z-]*\\.?", s);
            if (matches && !isStopWord(s)) {
                Integer numberOfOccurances = words.get(s);
                if (numberOfOccurances != null) {
                    words.put(s, numberOfOccurances + 1);
                } else {
                    words.put(s, 1);
                }
                wordCount++;
            }
        }
        return wordCount;
    }

    public int getUniqueWords() {
        return words.entrySet().size();
    }

}
