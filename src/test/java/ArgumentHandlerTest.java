import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ArgumentHandlerTest {
    @Test
    public void testArgumentHandlerWithIndexFlagOnly(){
        String[] args = {"-index"};
        ArgumentHandler handler = new ArgumentHandler(args);
        assertTrue(handler.isIndexFlagProvided());
    }
    @Test
    public void testArgumentHandlerWithDictionaryFlag(){
        String[] args = {"-dictionary=file.txt"};
        ArgumentHandler handler = new ArgumentHandler(args);
        assertTrue(handler.isDictionaryFlagProvided());
        assertEquals("file.txt",handler.getDictionaryFilename());
    }
    @Test
    public void testArgumentHandlerWithFilenameOnly(){
        String[] args = {"file.txt"};
        ArgumentHandler handler = new ArgumentHandler(args);
        assertEquals("file.txt", handler.getFilename());
    }
    @Test
    public void testArgumentHandlerWithEveryFlag(){
        String[] args = {"-index","-dictionary=dict.txt","file.txt"};
        ArgumentHandler handler = new ArgumentHandler(args);
        assertEquals("file.txt", handler.getFilename());
        assertTrue(handler.isDictionaryFlagProvided());
        assertEquals("dict.txt",handler.getDictionaryFilename());
        assertTrue(handler.isIndexFlagProvided());
    }
}
