package userinput;

import org.junit.Assert;
import org.junit.Test;

public class FileInputReaderTest {

    @Test
    public void testNonemptyFile(){
        UserInputReader toTest = new FileInputReader("mytext.txt");
        Assert.assertEquals("Mary had a little lamb", toTest.readUserInput());
    }

    @Test
    public void testEmptyFile(){
        UserInputReader toTest = new FileInputReader("mytext_empty.txt");
        Assert.assertEquals("", toTest.readUserInput());
    }

    @Test
    public void testNonExistentFile(){
        UserInputReader toTest = new FileInputReader("dummy.txt");
        Assert.assertEquals("", toTest.readUserInput());
    }
}
