import java.io.File;
import java.util.Arrays;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static final String EXCLUDED_FILE_NAME = "stopwords.txt";

    private static List<String> readUsersInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        List<String> input = new ArrayList<String>(Arrays.asList(text.trim().split("\\s+")));
        Iterator<String> interator = input.iterator();
        while (interator.hasNext()) {
            if (!interator.next().matches("[a-zA-Z]+\\.?")) {
                interator.remove();
            }
        }
        return input;
    }

    private static File getStopWordsFile() {
        ClassLoader classLoader = new Main().getClass().getClassLoader();
        return new File(classLoader.getResource(EXCLUDED_FILE_NAME).getFile());
    }

    public static void main(String[] args) {
        ExcludedWords excludedWords = new ExcludedWords(getStopWordsFile());
        List<String> textList = readUsersInput();
        textList.removeAll(excludedWords.getExcludedWords());
        System.out.println("Number of words: " + textList.size());
    }
}
