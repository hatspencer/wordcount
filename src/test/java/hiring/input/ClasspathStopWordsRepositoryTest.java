package hiring.input;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClasspathStopWordsRepositoryTest {

    @Test
    public void containsWord() {
        ClasspathStopWordsRepository repository = new ClasspathStopWordsRepository("test-stopwords.txt");
        Assert.assertTrue(repository.containsWord("alpha"));
        Assert.assertTrue(repository.containsWord("beta"));
        Assert.assertFalse(repository.containsWord("gamma"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsWord_notExistingResource() {
        ClasspathStopWordsRepository repository = new ClasspathStopWordsRepository("random");
        repository.containsWord("xxxx");
    }
}
