import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Foo {

    private static final Set<String> STOP_WORDS = new HashSet<>();
    private static final String STOP_WORDS_FILENAME = "src/main/resources/stopwords.txt";

    public static void main(String[] args) {

        readStopWords(STOP_WORDS);

        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        System.out.println("Number of words: " + countWords(sentence, STOP_WORDS));

        scanner.close();
    }

    public static long countWords(String sentence, Set<String> stopWords) {

        if (sentence == null) {
            sentence = "";
        }

        String[] words = sentence.split(" ");

        long numWords = Arrays.stream(words)
                .filter(Foo::isWord)
                .filter(s -> stopWords == null || !stopWords.contains(s))
                .count();

        return numWords;
    }

    public static boolean isWord(String word) {
        if (word == null || word.trim().isEmpty()) {
            return false;
        }
        return word.replaceAll("[a-zA-Z]", "").length() == 0;
    }

    private static void readStopWords(Set<String> stopWords) {
        try {
            File myObj = new File(STOP_WORDS_FILENAME);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stopWords.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }


}
