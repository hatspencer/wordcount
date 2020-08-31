import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class WordCountExample {

    public static final String wordDefinition = "[a-zA-Z-]*\\.?";
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

        int wordCount = wordCountExample.getWordCountWithoutStopWords(text);
        int wordCountUnique = wordCountExample.getWordCountUnique(text);
        System.out.println("Number of words: " + wordCount + ", unique: " + wordCountUnique);
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
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (matches && !s.isEmpty()) {
                wordCount++;
            }
        }
        return wordCount;
    }

    private String[] getSplitStrings(String text) {
        String trim = text.trim();
        if (trim.isEmpty()) {
            return null;
        }
        return trim.split("[\\s+-]");
    }

    boolean isStopWord(String word) {
        return stopWords.contains(word);
    }

    public int getWordCountWithoutStopWords(String text) {
        readStopWords("./src/main/resources/stopwords.txt");
        int wordCount = 0;
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (matches && !s.isEmpty() && !isStopWord(s)) {
                wordCount++;
            }
        }
        return wordCount;
    }

    public int getWordCountUnique(String text) {
        readStopWords("./src/main/resources/stopwords.txt");
        String[] split = getSplitStrings(text);
        if (split == null) return 0;
        for (String s : split) {
            boolean matches = Pattern.matches(wordDefinition, s);
            if (matches && !s.isEmpty() && !isStopWord(s)) {
                Integer numberOfOccurances = words.get(s);
                if (numberOfOccurances != null) {
                    words.put(s, numberOfOccurances + 1);
                } else {
                    words.put(s, 1);
                }
            }
        }
        return getUniqueWords();
    }

    public int getUniqueWords() {
        return words.entrySet().size();
    }

}
