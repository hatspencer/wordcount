import org.junit.Assert;
import org.junit.Test;

public class ProgramArgumentsParserTest {

    @Test
    public void testIndexedOption() {
        Assert.assertTrue(new ProgramArgumentsParser(new String[]{"-index", "/var/local"}).isIndexedWords());
        Assert.assertTrue(new ProgramArgumentsParser(new String[]{"-index"}).isIndexedWords());
        Assert.assertTrue(new ProgramArgumentsParser(new String[]{"/var/local", "-index"}).isIndexedWords());
        Assert.assertTrue(new ProgramArgumentsParser(new String[]{"/var/local", "-dictionary=/usr/lib", "-index"}).isIndexedWords());
        Assert.assertFalse(new ProgramArgumentsParser(new String[]{"/var/local", "-dictionary=/usr/lib"}).isIndexedWords());
    }

    @Test
    public void testInputTextFilePathLocation() {
        Assert.assertEquals("/var/local", new ProgramArgumentsParser(new String[]{"-index", "/var/local"}).getInputTextFilePath());
        Assert.assertEquals("/var/local", new ProgramArgumentsParser(new String[]{"/var/local"}).getInputTextFilePath());
        Assert.assertEquals("/var/local", new ProgramArgumentsParser(new String[]{"/var/local", "-index"}).getInputTextFilePath());
        Assert.assertEquals("/var/local", new ProgramArgumentsParser(new String[]{"/var/local", "-dictionary=/usr/lib", "-index"}).getInputTextFilePath());

        Assert.assertFalse(new ProgramArgumentsParser(new String[]{"-dictionary=/usr/lib", "-index"}).isInputTextFileSet());
    }

    @Test
    public void testDictionaryFileLocation() {
        Assert.assertEquals("/usr/lib", new ProgramArgumentsParser(new String[]{"/var/local", "-dictionary=/usr/lib", "-index"}).getDictionaryPath());
        Assert.assertEquals("/usr/lib", new ProgramArgumentsParser(new String[]{"-dictionary=/usr/lib", "-index"}).getDictionaryPath());
        Assert.assertEquals("/usr/lib", new ProgramArgumentsParser(new String[]{"/var/local", "-index", "-dictionary=/usr/lib"}).getDictionaryPath());
        Assert.assertEquals("/usr/lib", new ProgramArgumentsParser(new String[]{"-index", "-dictionary=/usr/lib"}).getDictionaryPath());

        Assert.assertNull(new ProgramArgumentsParser(new String[]{"/usr/lib", "-index"}).getDictionaryPath());
    }
}
