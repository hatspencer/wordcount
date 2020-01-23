package wordcount;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordCounter {

    public static int countWordsInUserInput(String userInput) {
        List<String> potentialWords = Arrays.asList(userInput.split("(\\s)"));

        List<String> words = potentialWords.stream()
                .filter(potentialWord -> !potentialWord.isEmpty())
                .filter(potentialWord -> potentialWord.chars().allMatch(Character::isLetter))
                .collect(Collectors.toList());
        return words.size();
    }
}
