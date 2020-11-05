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

    @Override
    public void printData(Set<String> countedWords) {
        if (countedWords != null) {
            Integer countOfUnknown = calculateUnknown(countedWords);
            print(String.format("Index (unknown: %d)", countOfUnknown));
            for (String entry : countedWords) {
                String textToPrint = getTextToPrint(entry);
                print(textToPrint);
            }
        }
    }

    protected void print(String text) {
        System.out.println(text);
    }
}
