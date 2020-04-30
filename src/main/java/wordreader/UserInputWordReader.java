package wordreader;

import java.util.*;

public class UserInputWordReader implements WordReader {

    @Override
    public Collection<String> readWords() {

        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);

        String sentence = scanner.nextLine();

        scanner.close();

        return Arrays.asList(sentence.split(" "));
    }


}
