package at.erste;

import java.util.Set;

public class DictionaryServiceImpl implements DictionaryService {

    private Set<String> dictionary;

    public DictionaryServiceImpl(Set<String> dictionary) {
        this.dictionary = dictionary;

    }
    public String getTextToPrint(String entry) {
        String result = entry;
        if (!dictionary.contains(entry)) {
            result = entry + "*";
        }
        return result;
    }

    @Override
    public Integer calculateUnknown(Set<String> countedWords) {
        Integer result = 0;
        for (String word : countedWords) {
            if (!dictionary.contains(word)){
                result++;
            }
        }
        return result;
    }
}
