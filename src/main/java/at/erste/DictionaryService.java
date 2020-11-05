package at.erste;

import java.util.Set;

public interface DictionaryService {

    String getTextToPrint(String entry);

    Integer calculateUnknown(Set<String> countedWords);
}
