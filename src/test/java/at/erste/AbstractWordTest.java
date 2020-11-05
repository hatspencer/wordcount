package at.erste;

import at.erste.api.SentenceInformation;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractWordTest {

    protected Integer countSentence(String sentence) {
        prepareSplitWordUtil();
        return SplitWordCounterUtil.countWords(sentence);
    }

    protected SentenceInformation getSentenceInformation(String sentence) {
        prepareSplitWordUtil();
        return SplitWordCounterUtil.getSentenceInformation(sentence);
    }

    private void prepareSplitWordUtil() {
        SplitWordCounterUtil.setStopWordsProvider(new StopWordsProvider() {
            @Override
            public List<String> getLowerCaseStopWords() {
                return Arrays.asList("the", "a", "on", "off");
            }
        });
    }

}
