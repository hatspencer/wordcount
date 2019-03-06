import java.util.ArrayList;
import java.util.List;

import com.erste.main.util.StringFilter;
import com.erste.main.util.StringUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringFilterTest {

    private static final String TEXT_WITH_STOP_WORDS = "Hello ERSTE Group";
    private static final List<String> STOP_WORDS = new ArrayList<String>() {{
        add("ERSTE");
        add("Group");
    }};

    @Test
    public void filterOutWords() {
        List<String> filteredStrings = new StringFilter().filterOutStrings(STOP_WORDS, StringUtil.getWhiteSpaceSeparatedWords(TEXT_WITH_STOP_WORDS));
        Assertions.assertEquals(filteredStrings.size(), 1);
        Assertions.assertEquals(filteredStrings.get(0), "Hello");
    }
}
