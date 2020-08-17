import java.io.IOException;

public final class App {

    public static void main(final String[] args) throws IOException {
        final SentenceReader sentenceReader = new SentenceReader();
        final String sentence = sentenceReader.read(args);
        final AbstractWordCounter wordCounter = new WordCounterI();
        final WordCounterResult wordsCount = wordCounter.count(sentence);

        System.out.println("Number of words: " + wordsCount);
    }

}