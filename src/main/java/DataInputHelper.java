import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataInputHelper {

    public List<String> readStopWordsFile() {
        return readFileFromResource("stopWords.txt");
    }

    public String readWordsToCount(String filename) {
        String wordsToCount;
        if (filename != null) {
            List<String> wordsToCountList = readFileFromResource(filename);
            wordsToCount = String.join(" ", wordsToCountList);
        } else {
            wordsToCount = readUserInput();
        }
        return wordsToCount;
    }

    private List<String> readFileFromResource(String filename) {
        List<String> stopWordsList = new ArrayList<>();
        try {
            stopWordsList = Files.readAllLines(new File(filename).toPath());
        } catch (IOException e) {
            System.out.println("Error reading " + filename + " file: " + e);
        }
        return stopWordsList;
    }

    private String readUserInput() {
        System.out.println("Enter text: ");
        Scanner userInputScanner = new Scanner(System.in);
        return userInputScanner.nextLine();
    }
}
