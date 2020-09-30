import java.util.Scanner;

public class Application {

    private CountService countService;

    public Application(CountService countService) {
        this.countService = countService;
    }

    public static void main(String[] args) {
        StopWordsService stopWordsService = new StopWordsService();
        Application application = new Application(new CountService(stopWordsService.getStopWords()));
        application.execute();
    }

    public void execute() {
        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        scanner.close();

        int numberOfWords = countService.countWords(inputText);

        System.out.println("Number of words: " + numberOfWords);
    }
}
