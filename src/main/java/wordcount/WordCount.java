package wordcount;

import wordcount.stopwords.StopWords;
import wordcount.stopwords.StopWordsReader;
import wordcount.wordcounter.Splitter;
import wordcount.wordcounter.Statistic;
import wordcount.wordcounter.input.Input;
import wordcount.wordcounter.input.InputFactory;
import wordcount.wordcounter.WordCounter;

import java.io.IOException;
import java.net.URISyntaxException;

public class WordCount {
    
    public static final String STOP_WORDS_FILENAME_PROPERTY = "stopWordsFilename";

    public static void main(String[] args) {
        wordCountCatchExceptions(getFilenameForInput(args));
    }

    private static String getFilenameForInput(String[] args) {
        if (args == null || args.length < 1) {
            return "";
        } else {
            return args[0];
        }
    }

    private static void wordCountCatchExceptions(String inputFile) {
      try {
          wordCount(inputFile);
      } catch (Exception e) {
          System.out.println("Exception happend - "+e.getMessage());
      }
    }

    private static String getUserInput(String filename) throws IOException {
        Input input = InputFactory.getInput(filename);
        return input.getInputData();
    }

    private static void wordCount(String inputFile) throws IOException, URISyntaxException {

        StopWords stopWords = readStopWords();

        String input = getUserInput(inputFile);
        String[] splittedInput = Splitter.split(input);
        Statistic statistic = WordCounter.getWordsCount(splittedInput, stopWords);
        System.out.println("Number of words: " + statistic.getWordCount() + ", unique: "+statistic.getUnique());
    }

    private static StopWords readStopWords() throws IOException, URISyntaxException {
        StopWords stopWords = new StopWords();
        StopWordsReader stopWordsReader = new StopWordsReader();
        stopWords.setStopWords(stopWordsReader.readWords());
        return stopWords;
    }
     
}
