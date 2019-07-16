import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.*;

public class MainIT {

    @Test
    public void itRunsWithConsoleInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("Humpty-Dumpty sat, on a wall. Humpty-Dumpty had a great fall.".getBytes());
        System.setIn(in);
        List<String> expectedList = new ArrayList<String>() {{
            add("Humpty-Dumpty");
            add("sat");
            add("wall");
            add("Humpty-Dumpty");
            add("had");
            add("great");
            add("fall");
        }};
        Assert.assertEquals(expectedList, Main.findWords(""));
    }

    @Test
    public void itRunsWithFileInput() {
        List<String> expectedList = new ArrayList<String>() {{
            add("Humpty-Dumpty");
            add("sat");
            add("wall");
            add("Humpty-Dumpty");
            add("had");
            add("great");
            add("fall");
        }};
        Assert.assertEquals(expectedList, Main.findWords("test.txt"));
    }
}

