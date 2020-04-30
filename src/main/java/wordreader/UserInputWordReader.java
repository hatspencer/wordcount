package wordreader;

import java.util.*;

public class UserInputWordReader extends ReaderBase {

    @Override
    public Collection<String> readWords() {

        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        scanner.close();

        return getWordsFromSentence(sentence);
    }


}
