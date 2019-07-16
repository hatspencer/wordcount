package input;

import org.junit.Assert;
import org.junit.Test;

public class UserInputFactoryTest {
    @Test
    public void itSelectCorrectUserInputOnEmptyString() {
        Assert.assertEquals(UserInputFactory.getUserInput("").getClass(), ConsoleUserInput.class);
    }

    @Test
    public void itSelectCorrectUserInputOnString() {
        Assert.assertEquals(UserInputFactory.getUserInput("test.txt").getClass(), FileUserInput.class);
    }
}
