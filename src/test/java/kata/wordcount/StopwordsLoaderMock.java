package kata.wordcount;

import java.util.Arrays;
import java.util.List;

class StopwordsLoaderMock extends StopwordsLoader {

    @Override
    List<String> loadStopwords() {
        return Arrays.asList("the", "a", "on", "off");
    }
}
