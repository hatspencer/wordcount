import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.imageio.IIOException;

import java.io.BufferedReader;
import java.io.IOException;

import static org.junit.Assert.*;

public class LoadStopWordInputTest {

    private static final String INVALID_PATH_TEST_STOP_WORD_FILE = "XXXX";

    private LoadStopWordInputImpl loadStopWordInput;

    @Before
    public void init(){
        loadStopWordInput = new LoadStopWordInputImpl();
    }

    @Test(expected = IOException.class)
    public void receiveValidFileLocationTest() throws IOException{
            loadStopWordInput.getStopWordFileByPath(INVALID_PATH_TEST_STOP_WORD_FILE);
    }

}
