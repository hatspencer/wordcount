import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataInputHelper {
    public List<String> readStopWordsFile() {
        List<String> stopWordsList = new ArrayList<>();
        try {
            stopWordsList = Files.readAllLines(new File("stopWords.txt").toPath());
        } catch (IOException e) {
            System.out.println("Error reading stop words file: " + e);
        }
        return stopWordsList;
    }

    public String readWordsToCount(String filename) {
        String wordsToCount = null;
        if (filename != null) {
            List<String> wordsToCountList;
            try {
                wordsToCountList = Files.readAllLines(new File(filename).toPath());
                wordsToCount = String.join(" ", wordsToCountList);
            } catch (IOException e) {
                System.out.println("Error reading file with words to count: " + e);
            }
        } else {
            wordsToCount = readUserInput();
        }
        return wordsToCount;
    }

    private String readUserInput() {
        System.out.println("Enter text: ");
        Scanner userInputScanner = new Scanner(System.in);
        return userInputScanner.nextLine();
    }
}
