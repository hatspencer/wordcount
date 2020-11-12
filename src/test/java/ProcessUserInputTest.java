import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProcessUserInputTest {

    private ProcessUserInputImpl processInput;

    @Before
    public void init(){
        processInput = new ProcessUserInputImpl();
    }

    @Test
    public void receiveInputTest(){
        String input = "Test user given input";
        assertEquals(4, processInput.processUserInput(input));
    }
}
