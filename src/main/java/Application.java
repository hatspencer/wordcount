public class Application {

    public static void main(String[] args) {
        WordCounter wordCounter = new WordCounter(new StopWordReader());
        WordInputReaderFactory wordInputReaderFactory = new WordInputReaderFactory();
        WordInputReader wordInputReader = wordInputReaderFactory.create(args);
        WordOutputPrinter wordOutputPrinter = new WordOutputPrinter();

        String text = wordInputReader.processInput();
        wordOutputPrinter.printResult(text, wordCounter);
    }
}
