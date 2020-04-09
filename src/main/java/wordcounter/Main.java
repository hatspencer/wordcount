package wordcounter;

public class Main{

    public static void main(String[] args) {

        String input = new InputReader().readFromSystemIn("Enter text: ");
        WordCounter wordCounter = new WordCounter();

        int validWordsCount = wordCounter.countValidWords(input);

        System.out.printf( "Number of words: %s", validWordsCount);
    }
}
