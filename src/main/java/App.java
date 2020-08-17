import java.io.IOException;

public final class App {

    public static void main(final String[] args) throws IOException {
        final SentenceReader sentenceReader = new SentenceReader();
        final String sentence = sentenceReader.read(args);
        final AbstractSentenceSplitter wordCounter = new SentenceSplitterIV();
        final WordCounterResult result = wordCounter.split(sentence);
        result.printMessage();
    }

}