import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract class AbstractWordCount {

    List<String> stopwords;

    private int totalWords = 0;
    private int uniqueWords = 0;

    protected abstract BufferedReader getInput();

    public AbstractWordCount() throws IOException {
        readStopwords("stopwords.txt");
    }

    List<String> readAllLines(BufferedReader reader) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
        reader.close();
        return lines;
    }

    void readStopwords(String filename) throws IOException {
        File stopwordsFile = new File(filename);
        BufferedReader input = new BufferedReader(new FileReader(stopwordsFile));
        stopwords = readAllLines(input);
    }

    public int getTotalWords() {
        return totalWords;
    }

    public int getUniqueWords() {
        return uniqueWords;
    }

    public void doProcessing() throws IOException {
        determineCounts(readAllLines(getInput()));
    }

    void determineCounts(List<String> lines) {
        HashMap<String, Integer> wordCounts = new HashMap<>();
        for (String line : lines) {
            String[] parts = line.split(" ");
            for (String part : parts) {
                if (part.matches("[a-zA-Z-]+") && !stopwords.contains(part)) {
                    totalWords++;
                    wordCounts.merge(part, 1, Integer::sum);
                }
            }
        }
        uniqueWords = (int)wordCounts.values().stream().filter(v -> v.equals(1)).count();
    }
}
