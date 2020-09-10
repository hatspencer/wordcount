package hiring.input;

import org.junit.Assert;
import org.junit.Test;

public class ApplicationArgsTest {

    @Test
    public void parseArguments_allAcceptedArgs() {
        String[] args = new String[]{"file.txt", "-index", "-dictionary=dict.txt"};
        ApplicationArgs applicationArgs = new ApplicationArgs(args);

        Assert.assertEquals("file.txt", applicationArgs.getInputFilePath().toString());
        Assert.assertEquals("dict.txt", applicationArgs.getDictionaryFilePath().toString());
        Assert.assertTrue(applicationArgs.isPrintIndex());
    }

    @Test
    public void parseArguments_fileOnly() {
        String[] args = new String[]{"file.txt"};
        ApplicationArgs applicationArgs = new ApplicationArgs(args);

        Assert.assertEquals("file.txt", applicationArgs.getInputFilePath().toString());
        Assert.assertNull(applicationArgs.getDictionaryFilePath());
        Assert.assertFalse(applicationArgs.isPrintIndex());
    }

    @Test
    public void parseArguments_dictionaryOnly() {
        String[] args = new String[]{"-dictionary=dict.txt"};
        ApplicationArgs applicationArgs = new ApplicationArgs(args);

        Assert.assertNull(applicationArgs.getInputFilePath());
        Assert.assertEquals("dict.txt", applicationArgs.getDictionaryFilePath().toString());
        Assert.assertFalse(applicationArgs.isPrintIndex());
    }

    @Test
    public void parseArguments_indexOnly() {
        String[] args = new String[]{"-index"};
        ApplicationArgs applicationArgs = new ApplicationArgs(args);

        Assert.assertNull(applicationArgs.getInputFilePath());
        Assert.assertNull(applicationArgs.getDictionaryFilePath());
        Assert.assertTrue(applicationArgs.isPrintIndex());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseArguments_incorrectNumberOfArguments() {
        String[] args = new String[]{"file.txt", "-index", "random", "-dictionary=dict.txt"};
        new ApplicationArgs(args);
    }
}
