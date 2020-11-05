package at.erste;

import at.erste.api.ConfigProperties;
import at.erste.api.SentenceInformation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ErsteWordCounterApp {

    public static void main(String[] args) {
        String sentence;

        LoadConfigProperties confiService = new LoadConfigPropertiesImpl();
        ConfigProperties properties = confiService.loadConfiguration(args);

        FileReader fileReader = new FileReaderImpl();

        if (properties.getPathToInputPath() != null) {
            System.out.println("Reading file");
            String pathToFile = args[0];
            sentence = fileReader.readContentOfFile(pathToFile);
        } else {
            System.out.print("Enter text:");
            Scanner scanner = new Scanner(System.in);
            sentence = scanner.nextLine();
        }

        SplitWordCounterUtil.setStopWordsProvider(new StopWordsProviderImpl());
        SentenceInformation sentenceInformation = SplitWordCounterUtil.getSentenceInformation(sentence);

        Set<String> dictionary = new HashSet<>();
        if (properties.getDictionaryPath() != null) {
            dictionary = fileReader.getDictionary(properties.getDictionaryPath());
        }

        DictionaryService dictionaryService = new DictionaryServiceImpl(dictionary);
        System.out.println(String.format("Number of words: %d, unique: %d; average word length: %.2f", sentenceInformation.getWords(), sentenceInformation.getUnique(), sentenceInformation.getAverage()));
        if (sentenceInformation.getCountedWords() != null) {
            Integer countOfUnknown= dictionaryService.calculateUnknown(sentenceInformation.getCountedWords());
            System.out.println(String.format("Index (unknown: %d)", countOfUnknown));
            for (String entry : sentenceInformation.getCountedWords()) {
                String textToPrint = dictionaryService.getTextToPrint(entry);
                System.out.println(textToPrint);
            }
        }
    }
}
