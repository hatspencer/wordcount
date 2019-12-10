package wordcount;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StopWordsPredicateTest {

    @Test
    public void testBuildWithConstructor() {
        StopWordsPredicate predicate = new StopWordsPredicate(Arrays.asList("dog", "fox", "lazy"));
        final List<String> actual = Stream.of("The quick brown fox jumps over the lazy dog".split(" "))
            .filter(predicate)
            .collect(Collectors.toList());

        assertEquals(Arrays.asList("The quick brown jumps over the".split(" ")), actual);
    }

    @Test
    public void testBuildFromClasspath() throws IOException {
        final StopWordsPredicate predicate = StopWordsPredicate.fromInputStream(
            getClass().getResourceAsStream("StopWordsPredicateTest.txt")
        );
        
        assertTrue("dog, fox, lazy should all be stop words", Arrays.asList("dog", "fox", "lazy")
            .stream()
            .noneMatch(predicate));
    }
}