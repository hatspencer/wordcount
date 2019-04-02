package kata.wordcount;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class StopwordsLoader {

     List<String> loadStopwords() {
        String stopWordsFileLocation = "stopwords.txt";
        try {
            File file = new File(stopWordsFileLocation);
            Path path = file.toPath();
            return Files.readAllLines(path, Charset.defaultCharset());
        } catch (IOException ex) {
            throw new IllegalStateException(String.format("Unable to read from stopwords file at location %s", stopWordsFileLocation), ex);
        }
    }
}
