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
    public void receiveInputTextTest(){
        String input = "       Test USER given input ";
        assertEquals("Word count only containing only valid word doesn't match",4, processInput.processUserInput(input).size());
        input = "Test user gi6ven input";
        assertEquals("Word count only containing only invalid word with number returns incorrect size",3, processInput.processUserInput(input).size());
    }

    @Test
    public void receiveInvalidInputTypeTest(){
        String input = "";
        assertEquals("Word count containing only empty String returning incorrect size",0, processInput.processUserInput(input).size());
        assertEquals("Word count containing only empty String returning incorrect size",0, processInput.processUserInput(null).size());
    }

}
