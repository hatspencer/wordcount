package at.erste;

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

}
