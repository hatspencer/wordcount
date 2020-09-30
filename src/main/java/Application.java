
public class Application {

    private CountService countService;
    private InputProcessorService inputProcessorService;

    public Application(CountService countService, InputProcessorService inputProcessorService) {
        this.countService = countService;
        this.inputProcessorService = inputProcessorService;
    }

    public static void main(String[] args) {
        StopWordsService stopWordsService = new StopWordsService();
        InputProcessorService inputProcessorService;
        if(args != null && args.length == 1) {
            inputProcessorService = new FileInputProcessorService(args[0]);
        } else {
            inputProcessorService = new StandardInputProcessorService();
        }
        Application application = new Application(new CountService(stopWordsService.getStopWords()), inputProcessorService);
        application.execute();
    }

    public void execute() {

        String inputText = inputProcessorService.prepareTextInput();

        int numberOfWords = countService.countWords(inputText);

        System.out.println("Number of words: " + numberOfWords);
    }
}
