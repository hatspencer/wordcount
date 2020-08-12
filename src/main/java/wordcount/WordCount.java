package wordcount;

import wordcount.properties.PropertiesFactory;
import wordcount.properties.PropertiesReader;
import wordcount.stopwords.StopWords;
import wordcount.stopwords.StopWordsReader;

import java.io.IOException;

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

    private static void wordCount() throws IOException {
        PropertiesReader propertiesReader = PropertiesFactory.getPropertiesReader();
        StopWords stopWords = readStopWords(propertiesReader);

        String input = UserInput.getInputFromUser();
        String[] splittedInput = Splitter.split(input);
        int numberOfWords = WordCounter.getWordsCount(splittedInput, stopWords);
        System.out.println("Number of words: " + numberOfWords);
    }

    private static StopWords readStopWords(PropertiesReader propertiesReader) throws IOException {
        String filename = propertiesReader.getProperty(STOP_WORDS_FILENAME_PROPERTY);
        StopWords stopWords = new StopWords();
        stopWords.setStopWords(StopWordsReader.readWords(filename));
        return stopWords;
    }
     
}
