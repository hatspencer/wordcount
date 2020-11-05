package at.erste;

import at.erste.api.SentenceInformation;

import java.util.Set;

public interface DictionaryService {

    String getTextToPrint(String entry);

    Integer calculateUnknown(Set<String> countedWords);

    void printData(SentenceInformation sentenceInformation);
}
