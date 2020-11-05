package at.erste;

import java.util.Set;

public interface FileReader {

    String readContentOfFile(String path);

    Set<String> getDictionary(String pathToFile);
}
