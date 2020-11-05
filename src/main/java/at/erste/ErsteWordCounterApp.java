package at.erste;

import at.erste.api.SentenceInformation;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ErsteWordCounterApp {

    public static void main(String[] args) {
        String sentence;
        FileReader fileReader = new FileReaderImpl();

        Set<String> dictionary = new HashSet<>();
        String pathToInputFile = null;
        for (String arg : args) {
            if (arg.startsWith("-dictionary=")){
                String pathToFile = arg.replaceAll("-dictionary=", "");
                dictionary = fileReader.getDictionary(pathToFile);
            } else {
                pathToInputFile = arg;
            }
        }

        if (pathToInputFile != null) {
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
