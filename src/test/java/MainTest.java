import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    @Test
    public void itFiltersUsersInputCorrectly() {
        List<String> inputStrings = new ArrayList<String>() {{
            add("this");
            add("a");
            add("test");
            add("for");
            add("12345");
            add("!@!@#$!@");
            add("asasd!@#");
            add("123!@#");
        }};

        List<String> expected = new ArrayList<String>() {{
            add("this");
            add("a");
            add("test");
            add("for");
        }};
        Assert.assertEquals(Main.filterUsersInput(inputStrings), expected);
    }

}
