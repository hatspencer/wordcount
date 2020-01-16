package orchestrator;

import java.util.Set;

public interface StopWordReader {

    Set<String> getStopWords(String filename);
}
