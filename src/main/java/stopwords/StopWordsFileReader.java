package stopwords;

import orchestrator.StopWordReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StopWordsFileReader implements StopWordReader {

    @Override
    public Set<String> getStopWords(String filename) {
        try {
            File stopwordsFile = new File(this.getClass().getClassLoader().getResource(filename).getFile());
            return new HashSet<>(Files.readAllLines(stopwordsFile.toPath()));
        } catch (IOException | NullPointerException e) {
            System.out.println("Could not read stop words file.");
            return Collections.emptySet();
        }
    }
}
