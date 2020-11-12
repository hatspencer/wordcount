import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

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

        assertEquals(input, userInputl.receiveSystemInput());
    }

    @Test
    public void receiveEmptyInputTest(){
        String input = "";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertNull(userInputl.receiveSystemInput());
    }
}
