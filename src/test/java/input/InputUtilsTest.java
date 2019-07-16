package input;

import org.junit.Assert;
import org.junit.Test;

public class InputUtilsTest {
    @Test
    public void itSplitsToLineCorrectly() {
        String testString = "This is a test string";
        Assert.assertEquals(InputUtils.splitToLine(testString).size(), 5);
    }
}
