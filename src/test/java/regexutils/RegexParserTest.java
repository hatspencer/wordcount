package regexutils;

import org.junit.Assert;
import org.junit.Test;

public class RegexParserTest {

    @Test
    public void testWithDefaultDelimiters(){
        RegexParser toTest = new RegexParser("Mary had a little lamb");
        Assert.assertEquals(5, toTest.countWords());
    }

    @Test
    public void testWithCustomDelimiters(){
        RegexParser toTest = new RegexParser("Mary:had,a.little lamb", "[\\s.,:]");
        Assert.assertEquals(5, toTest.countWords());
    }

    @Test
    public void testSingleWord(){
        RegexParser toTest = new RegexParser("Mary");
        Assert.assertEquals(1, toTest.countWords());
    }

    @Test
    public void testEmptyInput(){
        RegexParser toTest = new RegexParser("");
        Assert.assertEquals(0, toTest.countWords());
    }

    @Test
    public void testWhitespaceOnlyInput(){
        RegexParser toTest = new RegexParser("");
        Assert.assertEquals(0, toTest.countWords());
    }


    @Test
    public void testMultipleWhitespacesInput(){
        RegexParser toTest = new RegexParser("Mary    had a     little lamb");
        Assert.assertEquals(5, toTest.countWords());
    }

    @Test
    public void testLeadingTrailingWhitespacesInput(){
        RegexParser toTest = new RegexParser("   Mary had a little lamb   ");
        Assert.assertEquals(5, toTest.countWords());
    }
}
