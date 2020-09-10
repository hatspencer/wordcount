package hiring;

import hiring.input.ResourceStopWordsRepository;
import hiring.input.ConsoleTextProvider;

public class WordCountApp {

    public void run() {
        TextProvider textProvider = createConsoleTextProvider();
        String text = textProvider.provideText();
        StopWordsRepository stopWordsRepository = createResourceStopWordsRepository();
        WordCounter wordCounter = createBasicWordCounter(stopWordsRepository);
        int count = wordCounter.countWords(text);
        printOutput(count);
    }

    private TextProvider createConsoleTextProvider() {
        return new ConsoleTextProvider();
    }

    private StopWordsRepository createResourceStopWordsRepository() {
        return new ResourceStopWordsRepository("stopwords.txt");
    }

    private WordCounter createBasicWordCounter(StopWordsRepository stopWordsRepository) {
        return new BasicWordCounter(stopWordsRepository);
    }

    private void printOutput(int count) {
        System.out.printf("Number of words: %d\n", count);
    }

    public static void main(String[] args) {
        new WordCountApp().run();
    }
}
