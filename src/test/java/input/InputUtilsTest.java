package input;

import org.junit.Assert;
import org.junit.Test;

public class InputUtilsTest {
    @Test
    public void itSplitsToLineCorrectly() {
        String testString = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        Assert.assertEquals(InputUtils.splitToLine(testString).size(), 12);
    }

    @Test
    public void itSplitsToLineCorrectlyOnEmpty() {
        String testString = "";
        Assert.assertEquals(InputUtils.splitToLine(testString).size(), 0);
    }
}
