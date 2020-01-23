import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApplicationTest {

    @Test
    @Disabled
    public void mainMethodShouldExecuteStartup() {
        try {
            Application.main(new String[]{});
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
