import org.junit.Assert;
import org.junit.Test;

public class FileInputTextProviderTest {

    private static final String EXPECTED_RESULT = "Mary had\n" +
            "a little\n" +
            "lamb";

    private static final String  EXPECTED_FILE_NOT_FOUND_MESSAGE = "File %s not found";

    @Test
    public void testReadingFromInputFile() {
        String inputFromFile = new FileInputTextProvider("src/test/resources/text.txt").getInput();

        Assert.assertEquals("Text read from file is not as expected", EXPECTED_RESULT, inputFromFile);
    }

    @Test
    public void testReadingFromNonExistingFile() {
        String badFileLocation = "src/test/resources/text_not_existing.txt";
        try {
            new FileInputTextProvider(badFileLocation).getInput();
            Assert.fail("Expected WordCountException");
        } catch (WordCountException ex) {
            String expectedMessage = String.format(EXPECTED_FILE_NOT_FOUND_MESSAGE,badFileLocation);
            Assert.assertEquals(expectedMessage, ex.getMessage());
        }
    }
}
