package hiring.input;

import org.junit.Assert;
import org.junit.Test;

public class ResourceStopWordsRepositoryTest {

    @Test
    public void containsWord() {
        ResourceStopWordsRepository repository = new ResourceStopWordsRepository("test-stopwords.txt");
        Assert.assertTrue(repository.containsWord("alpha"));
        Assert.assertTrue(repository.containsWord("beta"));
        Assert.assertFalse(repository.containsWord("gamma"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsWord_notExistingResource() {
        ResourceStopWordsRepository repository = new ResourceStopWordsRepository("random");
        repository.containsWord("xxxx");
    }
}
