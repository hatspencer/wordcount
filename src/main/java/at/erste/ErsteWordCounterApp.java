package at.erste;

import at.erste.api.SentenceInformation;

import java.util.Scanner;

public class ErsteWordCounterApp {

    public static void main(String[] args) {
        String sentence = null;
        if (args.length == 0) {
            System.out.print("Enter text:");
            Scanner scanner = new Scanner(System.in);
            sentence = scanner.nextLine();
        } else {
            System.out.println("Reading file");
            String pathToFile = args[0];
            FileReaderImpl fileReader = new FileReaderImpl();
            sentence = fileReader.readContentOfFile(pathToFile);
        }


        SplitWordCounterUtil.setStopWordsProvider(new StopWordsProviderImpl());
        SentenceInformation sentenceInformation = SplitWordCounterUtil.getSentenceInformation(sentence);

        System.out.println(String.format("Number of words: %d, unique: %d; average word length: %.2f", sentenceInformation.getWords(), sentenceInformation.getUnique(), sentenceInformation.getAverage()));
    }

}
