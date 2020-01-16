import consoleprinter.WordCountProcessor;
import stopwords.StopWordReader;
import stopwords.StopWordsFileReader;

public class WordCountApp {

    public static void main(String[] args){
        StopWordReader stopWordReader = new StopWordsFileReader();
        new WordCountProcessor("Enter text: ", "Number of words: ", stopWordReader).process();
    }
}
