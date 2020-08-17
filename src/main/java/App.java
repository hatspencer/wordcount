import java.io.IOException;

public final class App {

    public static void main(final String[] args) throws IOException {
        final SentenceReader sentenceReader = new SentenceReader();
        sentenceReader.read(args);
    }

}