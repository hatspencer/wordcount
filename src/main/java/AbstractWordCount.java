import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWordCount {

    List<String> stopwords;

    protected abstract BufferedReader getInput() throws IOException;

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

    public int getWordCount() throws IOException {
        return wordCountInList(readAllLines(getInput()));
    }

    int wordCountInList(List<String> lines) {
        int count = 0;
        for (String line : lines) {
            String[] parts = line.split(" ");
            for (String part : parts) {
                if (part.matches("[a-zA-Z]+") && !stopwords.contains(part)) {
                    count++;
                }
            }
        }
        return count;
    }
}
