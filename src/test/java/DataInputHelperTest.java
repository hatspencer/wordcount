import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataInputHelperTest {

    private static DataInputHelper dataInputHelper;

    @BeforeClass
    public static void setup() {
        dataInputHelper = new DataInputHelper();

    }

    @Test
    public void shouldReadWordsToCountFromFile() {
        String filename = "inputFile1";
        String expected = "Mary had a little lamb";
        String result = dataInputHelper.readWordsToCount(filename);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void shouldAskForUserInputIfFileNotFound() {
        // TODO test
    }
}
