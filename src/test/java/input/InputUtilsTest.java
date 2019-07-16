package input;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputUtilsTest {
    @Test
    public void itReadsFromConsole() {
        ByteArrayInputStream in = new ByteArrayInputStream("Humpty-Dumpty sat, on a wall. Humpty-Dumpty had a great fall.".getBytes());
        System.setIn(in);
        List<String> expectedList = new ArrayList<String>() {{
            add("Humpty");
            add("Dumpty");
            add("sat");
            add("on");
            add("a");
            add("wall");
            add("Humpty");
            add("Dumpty");
            add("had");
            add("a");
            add("great");
            add("fall");
        }};
        Assert.assertEquals(expectedList, InputUtils.readFromConsole());
    }

    @Test
    public void itReadsFromFile() {
        List<String> expectedList = new ArrayList<String>() {{
            add("Humpty");
            add("Dumpty");
            add("sat");
            add("on");
            add("a");
            add("wall");
            add("Humpty");
            add("Dumpty");
            add("had");
            add("a");
            add("great");
            add("fall");
        }};
        Assert.assertEquals(expectedList, InputUtils.readFromFile("test.txt"));
    }

    @Test
    public void itReadsFromResource() {
        List<String> expectedList = new ArrayList<String>() {{
            add("the");
            add("a");
            add("on");
        }};
        Assert.assertEquals(expectedList, InputUtils.readFromResource("stopwords.txt"));
    }

    @Test()
    public void itFailsWhenResourceWasNotExist() {
        try {
            InputUtils.readFromResource("not_exist.txt");
            Assert.fail("it should fail");
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Resource was not found");
        }
    }

    @Test
    public void itFailsWhenFileWasNotExist() {
        try {
            InputUtils.readFromFile("not_exist.txt");
            Assert.fail("it should fail");
        } catch (RuntimeException e) {
            Assert.assertEquals(e.getMessage(), "Resource was not found");
        }
    }

}
