package text.split.impl;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.Test;

import text.split.TextSplitter;

public class WhiteSpaceTextSplitterImplTest {

    @Test
    public void testNullText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split(null);
        assertEquals(0L, textItems.size());
    }

    @Test
    public void testEmptyText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("");
        assertEquals(0L, textItems.size());
    }

    @Test
    public void testWhiteSpaceOnlyText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split(" \t");
        assertEquals(0L, textItems.size());
    }

    @Test
    public void testMultipleWordsText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("text text\ttext\ntext");
        assertEquals(4L, textItems.size());
    }

    @Test
    public void testMultipleWhiteSpacesText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("text  text");
        assertEquals(2L, textItems.size());
    }

    @Test
    public void testFirstWhiteSpaceText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split(" text text");
        assertEquals(2L, textItems.size());
    }

    @Test
    public void testDashSeparatorText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("text-text");
        assertEquals(2L, textItems.size());
    }

    @Test
    public void testMultipleDashSeparatorText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("text--text");
        assertEquals(2L, textItems.size());
    }

    @Test
    public void testDashAtTheBeginningSeparatorText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("-text text");
        assertEquals(2L, textItems.size());
    }

    @Test
    public void testDashAtTheEndSeparatorText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("text text-");
        assertEquals(2L, textItems.size());
    }

    @Test
    public void testOnlyDashSeparatorText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("-");
        assertEquals(0L, textItems.size());
    }

    @Test
    public void testDashAndWhiteSpaceSeparatorText() {
        TextSplitter textSplitter = new WhiteSpaceTextSplitterImpl();
        Collection<String> textItems = textSplitter.split("text- text");
        assertEquals(2L, textItems.size());
    }
}