package wordcount;

import wordcount.stopwords.StopWords;
import wordcount.stopwords.StopWordsReader;
import wordcount.wordcounter.Splitter;
import wordcount.wordcounter.UserInput;
import wordcount.wordcounter.WordCounter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class WordCount {
    
    public static final String STOP_WORDS_FILENAME_PROPERTY = "stopWordsFilename";

    public static void main(String[] args) {
        wordCountCatchExceptions();
    }

    private static void wordCountCatchExceptions() {
      try {
          wordCount();
      } catch (Exception e) {
          System.out.println("Exception happend - "+e.getMessage());
      }
    }

    private static void wordCount() throws IOException, URISyntaxException {
        StopWords stopWords = readStopWords();

        String input = UserInput.getInputFromUser();
        String[] splittedInput = Splitter.split(input);
        int numberOfWords = WordCounter.getWordsCount(splittedInput, stopWords);
        System.out.println("Number of words: " + numberOfWords);
    }

    private static StopWords readStopWords() throws IOException, URISyntaxException {
        StopWords stopWords = new StopWords();
        StopWordsReader stopWordsReader = new StopWordsReader();
        stopWords.setStopWords(stopWordsReader.readWords());
        return stopWords;
    }
     
}
