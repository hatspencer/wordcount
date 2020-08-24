import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WordCountMain {

    List<String> stopwords;

    public WordCountMain() throws IOException {
        readStopwords("stopwords.txt");
    }

    public static void main(String[] args) throws IOException {
        WordCountMain app = new WordCountMain();
        System.out.print("Enter text: ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String line = input.readLine();
        System.out.printf("Number of words %d%n", app.wordCount(line));
    }

    void readStopwords(String filename) throws IOException {
        stopwords = new ArrayList<>();
        File stopwordsFile = new File(filename);
        BufferedReader input = new BufferedReader(new FileReader(stopwordsFile));
        String stopword;
        while ((stopword = input.readLine()) != null) {
            stopwords.add(stopword);
        }
        input.close();
    }

    int wordCount(String line) {
        String[] parts = line.split(" ");
        int count = 0;
        for (String part : parts) {
            if (part.matches("[a-zA-Z]+") && !stopwords.contains(part)) {
                count++;
            }
        }
        return count;
    }
}
