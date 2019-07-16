import com.sun.org.apache.xerces.internal.xs.StringList;
import javafx.application.Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class ExcludedWords {
    private List<String> excludedWords;

    public ExcludedWords(File file) {
        BufferedReader reader;
        excludedWords = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                excludedWords.add(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> getExcludedWords() {
        return excludedWords;
    }
}
