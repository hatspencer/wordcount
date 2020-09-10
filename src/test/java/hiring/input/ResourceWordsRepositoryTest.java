package hiring.input;

import org.junit.Assert;
import org.junit.Test;

public class ResourceWordsRepositoryTest {

    @Test
    public void containsWord() {
        ResourceWordsRepository repository = new ResourceWordsRepository("test-stopwords.txt");
        Assert.assertTrue(repository.containsWord("alpha"));
        Assert.assertTrue(repository.containsWord("beta"));
        Assert.assertFalse(repository.containsWord("gamma"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void containsWord_notExistingResource() {
        ResourceWordsRepository repository = new ResourceWordsRepository("random");
        repository.containsWord("xxxx");
    }
}
