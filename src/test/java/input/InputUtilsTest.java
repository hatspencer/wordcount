package input;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class InputUtilsTest {
    @Test
    public void itSplitsToLineCorrectly() {
        String testString = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        Assert.assertEquals(InputUtils.splitToLines(testString).size(), 12);
    }

    @Test
    public void itSplitsToLineCorrectlyOnEmpty() {
        String testString = "";
        Assert.assertEquals(InputUtils.splitToLines(testString).size(), 0);
    }

    @Test
    public void itReadsFromConsole() {
        ByteArrayInputStream in = new ByteArrayInputStream("Humpty-Dumpty sat, on a wall. Humpty-Dumpty had a great fall.".getBytes());
        System.setIn(in);
        List<String> expectedList = new ArrayList<String>() {{
            add("Humpty");
            add("Dumpty");
            add("sat");
            add("wall");
            add("Humpty");
            add("Dumpty");
            add("had");
            add("great");
            add("fall");
        }};
        Assert.assertEquals(expectedList, InputUtils.readFromConsole());
    }
}
