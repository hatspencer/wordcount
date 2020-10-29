public class WordOutputPrinter {

    public void printResult(String text, WordCounter wordCounter) {
        System.out.printf("Number of words: %d, unique: %d",
                wordCounter.countWords(text),
                wordCounter.countUniqueWords(text));
    }

    public void printEnterText() {
        System.out.print("Enter Text: ");
    }
}
