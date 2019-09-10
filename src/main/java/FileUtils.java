import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class FileUtils {

    static String[] readWordsFromFile(String filename) {
        List<String> words = new ArrayList<>();
        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            while ((line = reader.readLine()) != null) {
                words.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println(filename + "not found");
        } catch (IOException ex) {
            System.out.println("Cannot open file");
        }
        return words.toArray(new String[0]);
    }
    static String getSentenceFromFile(String filename) {
        String[] lines = FileUtils.readWordsFromFile(filename);
        StringBuilder builder = new StringBuilder();
        for (String line : lines) {
            builder.append(line).append(" ");
        }
        return builder.toString().trim();
    }
}
