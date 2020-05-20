package cz.rleifer.test.wordcounter.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static cz.rleifer.test.wordcounter.core.impl.Constants.EMPTY_STRING;
import static cz.rleifer.test.wordcounter.core.impl.Constants.STOPWORD_ARGUMENT_NAME;

public class ArgumentResolverTest {

    public static final String TEXT_FILE_PATH = "/text/fileText.txt";
    public static final String STOP_WORD_FILE_PATH = "/text/stopWord.txt";

    @Test
    public void testNoArgument() {
        genericTest(Collections.EMPTY_LIST, EMPTY_STRING, EMPTY_STRING);
    }

    @Test
    public void testTextFilePassedOnly() {
        genericTest(new ArrayList<>(Arrays.asList(TEXT_FILE_PATH)), TEXT_FILE_PATH, EMPTY_STRING);
    }

    @Test
    public void testSkipWordFilePassedOnly() {
        genericTest(new ArrayList<>(Arrays.asList(STOPWORD_ARGUMENT_NAME, STOP_WORD_FILE_PATH)), EMPTY_STRING, STOP_WORD_FILE_PATH);
    }

    @Test
    public void testSkipWordAndTextFilePassed() {
        genericTest(new ArrayList<>(Arrays.asList(TEXT_FILE_PATH, STOPWORD_ARGUMENT_NAME, STOP_WORD_FILE_PATH)), TEXT_FILE_PATH, STOP_WORD_FILE_PATH);
    }

    private void genericTest(List<String> arguments,String expectedTextFilePath, String expectedStopWordFilePath) {
        String inputFilePath = ArgumentResolver.getInputFilePath(arguments);
        String stopWordFilePath = ArgumentResolver.getStopWordFilePath(arguments);
        Assert.assertEquals(expectedTextFilePath, inputFilePath);
        Assert.assertEquals(expectedStopWordFilePath, stopWordFilePath);
    }

}
