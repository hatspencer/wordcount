import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordsDictionaryFactoryTest {

    private static final List<String> DICTIONARY_VALUES = Arrays.asList("one", "two", "three", "four", "five");

    private static final  String FILE_NOT_FOUND_FORMAT = "File %s not found";

    @Test
    public void testDictionaryContainsALlValues() {
        WordsDictionary dictionary = WordsDictionaryFactory.getInstance("dictionary_test.txt", false);

        DICTIONARY_VALUES.forEach(
                value -> Assert.assertTrue("Dictionary does not contain: " + value, dictionary.containsWord(value))
        );
    }

    @Test
    public void testCreateDictionaryForNonExistingFile() {
        String nonExistingFileName = "dictionary_nonexisting.txt";
        try {
            WordsDictionaryFactory.getInstance(nonExistingFileName, false);
            Assert.fail("WordCountException expected");
        } catch (WordCountException ex) {
            String message = String.format(FILE_NOT_FOUND_FORMAT, nonExistingFileName);
            Assert.assertEquals(message, ex.getMessage());
        }
    }
}
