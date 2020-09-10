package hiring;

import hiring.WordCounter.WordCount;
import hiring.input.ApplicationArgs;
import hiring.input.BasicTextProviderFactory;
import hiring.input.ResourceStopWordsRepository;
import hiring.output.PrintStreamWordCountPrinter;

import java.nio.file.Path;

public class WordCountApp {

    public void run(String[] args) {
        ApplicationArgs applicationArgs = new ApplicationArgs(args);
        TextProvider textProvider = createTextProvider(applicationArgs.getInputFilePath());
        String text = textProvider.provideText();
        StopWordsRepository stopWordsRepository = createResourceStopWordsRepository();
        WordCounter wordCounter = createBasicWordCounter(stopWordsRepository);
        WordCountPrinter wordCountPrinter = createPrintStreamWordCountPrinter(applicationArgs.isPrintIndex());
        WordCount wordCount = wordCounter.countWords(text);
        wordCountPrinter.printWordCount(wordCount, System.out);
    }

    private TextProvider createTextProvider(Path inputFilePath) {
        TextProviderFactory factory = new BasicTextProviderFactory(inputFilePath);
        return factory.createTextProvider();
    }

    private StopWordsRepository createResourceStopWordsRepository() {
        return new ResourceStopWordsRepository("stopwords.txt");
    }

    private WordCounter createBasicWordCounter(StopWordsRepository stopWordsRepository) {
        return new BasicWordCounter(stopWordsRepository);
    }

    private WordCountPrinter createPrintStreamWordCountPrinter(boolean printIndex) {
        return new PrintStreamWordCountPrinter(printIndex);
    }

    public static void main(String[] args) {
        new WordCountApp().run(args);
    }
}
