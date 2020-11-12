import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class UserInputTest {

    private UserInputImpl userInputl;

    @Before
    public void init(){
        userInputl = new UserInputImpl();
    }

    @Test
    public void receiveInputTest(){
        String input = "Test user given input";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(input, userInputl.receiveSystemInput());
    }
}
