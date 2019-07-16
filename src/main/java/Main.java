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
        List<String> input =  new ArrayList<String>(Arrays.asList(text.trim().split("\\s+")));
        Iterator<String> interator = input.iterator();
        while (interator.hasNext()){
            if(!interator.next().matches("[a-zA-Z]+\\.?")){
                interator.remove();
            }
        }
        return input;
    }

    public static void main(String[] args) {
        ClassLoader classLoader = new Main().getClass().getClassLoader();
        File excludedFile = new File(classLoader.getResource(EXCLUDED_FILE_NAME).getFile());
        ExcludedWords excludedWords = new ExcludedWords(excludedFile);
        List<String> textList = readUsersInput();
        textList.removeAll(excludedWords.getExcludedWords());
        System.out.println("Number of words: " + textList.size());
    }
}
