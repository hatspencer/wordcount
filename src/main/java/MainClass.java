

public class MainClass {

    public static void main(String[] args) {
        WordCount wordCount = new WordCount(new UserInputImpl(), new ProcessUserInputImpl(), args);
        wordCount.wordCount();
    }
}
