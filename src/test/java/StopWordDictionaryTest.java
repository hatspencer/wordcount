import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StopWordDictionaryTest {

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
}
