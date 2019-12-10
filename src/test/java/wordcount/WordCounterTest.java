package wordcount;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Optional;
import java.util.Queue;

import static java.util.Optional.empty;
import static org.junit.Assert.assertEquals;

/**
 * @author Nándor Előd Fekete
 */
public class WordCounterTest {

    private static class DummyTokenizer implements Tokenizer {

        private final Queue<String> tokenQueue;

        public DummyTokenizer(String... tokens) {
            this.tokenQueue = new ArrayDeque<>(Arrays.asList(tokens));
        }

        @Override
        public Optional<String> nextToken() {
            if (tokenQueue.isEmpty()) {
                return empty();
            } else {
                return Optional.of(tokenQueue.poll());
            }
        }
    }
    private void testWordCounter(long expected, String... tokens) {
        assertEquals(expected, new WordCounter().wordCount(new DummyTokenizer(tokens)));
    }


    @Test
    public void emptyTest() {
        testWordCounter(0);
    }

    @Test
    public void nonEmptyTest() {
        testWordCounter(1, "one");
        testWordCounter(2, "one", "two");
    }


}
