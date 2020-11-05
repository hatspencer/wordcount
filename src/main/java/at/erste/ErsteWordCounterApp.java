package at.erste;

import at.erste.api.ConfigProperties;
import at.erste.api.SentenceInformation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ErsteWordCounterApp {

    public static void main(String[] args) {
        String sentence = null;
        boolean isFile = false;

        LoadConfigProperties confiService = new LoadConfigPropertiesImpl();
        ConfigProperties properties = confiService.loadConfiguration(args);

        FileReader fileReader = new FileReaderImpl();

        if (properties.getPathToInputPath() != null) {
            System.out.println("Reading file");
            String pathToFile = args[0];
            sentence = fileReader.readContentOfFile(pathToFile);
            isFile = true;
        }
        boolean isLoop = true;
        while (isLoop) {
            if (!isFile) {
                System.out.print("Enter text:");
                Scanner scanner = new Scanner(System.in);
                sentence = scanner.nextLine();
                if (sentence == null || "".equalsIgnoreCase(sentence)) {
                    break;
                }
            } else {
                isLoop = false;
            }

            SplitWordCounterUtil.setStopWordsProvider(new StopWordsProviderImpl());
            SentenceInformation sentenceInformation = SplitWordCounterUtil.getSentenceInformation(sentence);

            Set<String> dictionary = new HashSet<>();
            if (properties.getDictionaryPath() != null) {
                dictionary = fileReader.getDictionary(properties.getDictionaryPath());
            }

            DictionaryService dictionaryService = new DictionaryServiceImpl(dictionary);
            dictionaryService.printData(sentenceInformation);
        }
    }
}
