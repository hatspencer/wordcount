import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class WordCounterTest {

    @Test
    public void countInputWithOnlyValidWords() {
        WordCounter wc = new WordCounter();
        String str = "mary has a litle lamb";
        long numOfWords = wc.countValidWords(str);
        assertEquals(5, numOfWords);
    }

    @Test
    public void countInputWithOnlyInvalidWords() {
        WordCounter wc = new WordCounter();
        String str = "mary has a litle !lamb";
        long numOfWords = wc.countValidWords(str);
        assertEquals(4, numOfWords);
    }

    @Test
    public void countInputUsingStopWords() throws IOException {
        WordCounter wc = new WordCounter();
        List<String> stopWords = Files.readAllLines(Paths.get("stopwords.txt"), StandardCharsets.UTF_8);
        String input = "mary has a litle lamb";
        long numOfWords = wc.countValidWords(input, stopWords);
        assertEquals(4, numOfWords);
    }

    @Test
    public void countUniqueWords() throws IOException {
        WordCounter wc = new WordCounter();
        List<String> stopWords = Files.readAllLines(Paths.get("stopwords.txt"), StandardCharsets.UTF_8);
        String input = "Humpty-Dumpty sat on a wall. Humpty-Dumpty had a great fall.";
        long numOfWords = wc.countUniqueWords(input, stopWords);
        assertEquals(6, numOfWords);
    }
}


