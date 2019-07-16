import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class MainIT {

    @Test
    public void itRunsWithConsoleInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.".getBytes());
        System.setIn(in);
        Assert.assertEquals(Main.findNumberOfWords(""), 9);
    }

    @Test
    public void itRunsWithFileInput() {
        Assert.assertEquals(Main.findNumberOfWords("test.txt"), 9);
    }
}

