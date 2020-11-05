package at.erste;

import at.erste.api.SentenceInformation;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class TestDictionary {


    @Test
    public void testNotMatchingEntry() {
        DictionaryServiceImpl emptyDictionary = new DictionaryServiceImpl(new HashSet<>());
        Assert.assertEquals("testToFindInDictionary*", emptyDictionary.getTextToPrint("testToFindInDictionary"));
    }

    @Test
    public void testMatchingEntry() {
        String testKey = "testToFindInDictionary";
        Set<String> dictionary = new HashSet<>();
        dictionary.add(testKey);
        DictionaryServiceImpl emptyDictionary = new DictionaryServiceImpl(dictionary);
        Assert.assertEquals(testKey, emptyDictionary.getTextToPrint(testKey));
    }

    @Test
    public void testCountUnknown() {
        String testKey = "testToFindInDictionary";
        Set<String> empty = new HashSet<>();
        DictionaryServiceImpl emptyDictionary = new DictionaryServiceImpl(empty);

        HashSet<String> wordsToCheck = new HashSet<>();
        wordsToCheck.add("test");
        wordsToCheck.add("erste");
        Assert.assertEquals((Integer) 2, emptyDictionary.calculateUnknown(wordsToCheck));
    }

    @Test
    public void testCountKnown() {
        Set<String> ersteDictionary = new HashSet<>();
        ersteDictionary.add("erste");
        DictionaryServiceImpl emptyDictionary = new DictionaryServiceImpl(ersteDictionary);

        HashSet<String> wordsToCheck = new HashSet<>();
        wordsToCheck.add("test");
        wordsToCheck.add("erste");
        Assert.assertEquals((Integer) 1, emptyDictionary.calculateUnknown(wordsToCheck));
    }

    @Test
    public void testPrintData() {
        Set<String> ersteDictionary = new HashSet<>();
        ersteDictionary.add("erste");
        StringBuilder console = new StringBuilder();
        DictionaryServiceImpl emptyDictionary = new DictionaryServiceImpl(ersteDictionary) {
            @Override
            protected void print(String text) {
                console.append(text);
            }
        };
        HashSet<String> countedWords = new HashSet<>();
        countedWords.add("erste");
        countedWords.add("blesk");
        emptyDictionary.printData(new SentenceInformation(1,1,1d, countedWords));

        Assert.assertEquals("Number of words: 1, unique: 1; average word length: 1,00Index (unknown: 1)ersteblesk*", console.toString());

        new DictionaryServiceImpl(ersteDictionary).print("Test");
    }

}
