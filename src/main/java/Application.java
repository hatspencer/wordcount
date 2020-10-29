public class Application {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter(new StopWordReader());
        WordInputReaderFactory wordInputReaderFactory = new WordInputReaderFactory();
        WordInputReader wordInputReader = wordInputReaderFactory.create(args);

        String text = wordInputReader.processInput();
        String[] words = wordCounter.splitText(text);
        System.out.printf("Number of words: %d, unique: %d",
                wordCounter.countWords(words),
                wordCounter.countDistinctWords(words));
    }
}
