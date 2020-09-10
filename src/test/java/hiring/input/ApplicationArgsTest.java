package hiring.input;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationArgsTest {

    @Test
    public void parseArguments_correct() {
        String[] args = new String[]{"file.txt", "-index"};
        ApplicationArgs applicationArgs = new ApplicationArgs(args);

        Assert.assertEquals("file.txt", applicationArgs.getInputFilePath().toString());
        Assert.assertTrue(applicationArgs.isPrintIndex());
    }

    @Test
    public void parseArguments_fileOnly() {
        String[] args = new String[]{"file.txt"};
        ApplicationArgs applicationArgs = new ApplicationArgs(args);

        Assert.assertEquals("file.txt", applicationArgs.getInputFilePath().toString());
        Assert.assertFalse(applicationArgs.isPrintIndex());
    }

    @Test
    public void parseArguments_indexOnly() {
        String[] args = new String[]{"-index"};
        ApplicationArgs applicationArgs = new ApplicationArgs(args);

        Assert.assertNull(applicationArgs.getInputFilePath());
        Assert.assertTrue(applicationArgs.isPrintIndex());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseArguments_incorrectNumberOfArguments() {
        String[] args = new String[]{"file.txt", "-index", "random"};
        new ApplicationArgs(args);
    }
}
