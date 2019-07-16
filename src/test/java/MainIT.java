import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class MainIT {

    @Test
    public void itRunsWithConsoleInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("Mary had a little lamb".getBytes());
        System.setIn(in);
        Assert.assertEquals(Main.findNumberOnWords(""), 4);
    }

    @Test
    public void itRunsWithFileInput() {
        Assert.assertEquals(Main.findNumberOnWords("test.txt"), 4);
    }
}

