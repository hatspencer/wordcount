
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
        SanitizingService sanitizingService = new SanitizingService(stopWordsService.getStopWords());
        Application application = new Application(new CountService(sanitizingService), inputProcessorService);
        application.execute();
    }

    public void execute() {

        String inputText = inputProcessorService.prepareTextInput();

        Statistics statistics = countService.countWords(inputText);

        System.out.println("Number of words: " + statistics.getAllWordCount() + ", unique: " + statistics.getUniqueWordCount());
    }
}
