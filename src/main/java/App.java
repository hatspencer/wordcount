import java.io.IOException;

public final class App {

    public static void main(final String[] args) throws IOException {
        final SentenceReader sentenceReader = new SentenceReader();
        final String sentence = sentenceReader.read(args);
        final WordCounter wordCounter = new WordCounter();
        final WordCounterResult wordsCount = wordCounter.count2(sentence);

        System.out.println("Number of words: " + wordsCount);
    }

}