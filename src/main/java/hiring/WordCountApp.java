package hiring;

import hiring.WordCounter.WordCount;
import hiring.input.ApplicationArgs;
import hiring.input.BasicTextProviderFactory;
import hiring.input.FileWordsRepository;
import hiring.input.ResourceWordsRepository;
import hiring.output.PrintStreamWordCountPrinter;

import java.nio.file.Path;

public class WordCountApp {

    public void run(String[] args) {
        ApplicationArgs applicationArgs = new ApplicationArgs(args);
        TextSupplier textProvider = createTextSupplier(applicationArgs.getInputFilePath());
        WordsRepository stopWordsRepository = createResourceWordsRepository("stopwords.txt");
        WordCounter wordCounter = createBasicWordCounter(stopWordsRepository);
        WordsRepository dictionaryWordsRepository = createFileWordsRepository(applicationArgs.getDictionaryFilePath());
        WordCountPrinter wordCountPrinter = createPrintStreamWordCountPrinter(dictionaryWordsRepository, applicationArgs.isPrintIndex());

        textProvider.supplyText(text -> {
            WordCount wordCount = wordCounter.countWords(text);
            wordCountPrinter.printWordCount(wordCount, System.out);
        });
    }

    private TextSupplier createTextSupplier(Path inputFilePath) {
        TextProviderFactory factory = new BasicTextProviderFactory(inputFilePath);
        return factory.createTextProvider();
    }

    private WordsRepository createResourceWordsRepository(String resource) {
        return new ResourceWordsRepository(resource);
    }

    private WordsRepository createFileWordsRepository(Path filePath) {
        if (filePath != null) {
            return new FileWordsRepository(filePath);
        } else {
            return null;
        }
    }

    private WordCounter createBasicWordCounter(WordsRepository stopWordsRepository) {
        return new BasicWordCounter(stopWordsRepository);
    }

    private WordCountPrinter createPrintStreamWordCountPrinter(WordsRepository dictionaryWordsRepository, boolean printIndex) {
        return new PrintStreamWordCountPrinter(dictionaryWordsRepository, printIndex);
    }

    public static void main(String[] args) {
        new WordCountApp().run(args);
    }
}
