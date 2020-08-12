package wordcount;

import wordcount.stopwords.StopWords;
import wordcount.stopwords.StopWordsReader;
import wordcount.wordcounter.Splitter;
import wordcount.wordcounter.Statistic;
import wordcount.wordcounter.input.Input;
import wordcount.wordcounter.input.InputFactory;
import wordcount.wordcounter.WordCounter;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.text.DecimalFormat;

public class WordCount {
    
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
        writeOutputToUser(statistic);
    }

    private static StopWords readStopWords() throws IOException, URISyntaxException {
        StopWords stopWords = new StopWords();
        StopWordsReader stopWordsReader = new StopWordsReader();
        stopWords.setStopWords(stopWordsReader.readWords());
        return stopWords;
    }

    private static String prepareAverageToString(BigDecimal average) {
        average = average.setScale(2, BigDecimal.ROUND_HALF_UP);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(0);
        df.setGroupingUsed(false);
        return df.format(average);
    }

    private static void writeOutputToUser(Statistic statistic) {
        StringBuilder builder = new StringBuilder();
        builder.append("Number of words: ");
        builder.append(statistic.getWordCount());
        builder.append(", unique: ");
        builder.append(statistic.getUnique());
        builder.append("; average word length: ");
        builder.append(prepareAverageToString(statistic.getAverageWordLength()));
        builder.append(" characters");
        System.out.println(builder.toString());
    }
     
}
