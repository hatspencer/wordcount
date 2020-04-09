package wordcounter;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StopWordsTest {

    @Test
    public void readFromFile(){
        StopWords sut = new StopWords();
        List<String> stopwords = sut.readFromFile("stopwords.txt");

        Assert.assertEquals(4, stopwords.size());
    }

}