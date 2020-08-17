import junit.framework.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DataInputHelperTest {

    private static DataInputHelper dataInputHelper;

    @BeforeClass
    public static void setup() {
        dataInputHelper = new DataInputHelper();
    }

    @Test
    public void shouldReadWordsToCountFromFile() {
        String filename = "testFile1";
        String expected = "Mary had a little lamb.";
        String result = dataInputHelper.readWordsToCount(filename);
        Assert.assertEquals(result, expected);
    }

    @Test
    public void shouldAskForUserInputIfFileNotFound() {
        String filename = null;
        String input = "Mary had a little lamb";
        String expected = "Mary had a little lamb";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        String result = dataInputHelper.readWordsToCount(filename);
        Assert.assertEquals(result, expected);
    }
}
