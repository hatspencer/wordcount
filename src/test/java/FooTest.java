import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.regex.Pattern;

public class FooTest {

    @Test
    public void testFindMatchingWords() {

        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        String[] words = new String[]{"abc", "ABC", "123", "ab1", "1AB", "$$$", "$aB", "$1aB"};

        List<String> result = Foo.findMatchingWords(pattern, words);

        assertEquals(2, result.size());
    }
}
