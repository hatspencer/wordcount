
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
        SanitizingService sanitizingService = new SanitizingServiceImpl(stopWordsService.getStopWords());
        Application application = new Application(new CountService(sanitizingService), inputProcessorService);
        application.execute();
    }

    public void execute() {

        String inputText = inputProcessorService.prepareTextInput();

        Statistics statistics = countService.countWords(inputText);

        StringBuilder sb = new StringBuilder();
        sb.append("Number of words: ")
                .append(statistics.getAllWordCount())
                .append(", unique: " )
                .append(statistics.getUniqueWordCount())
                .append("; average word length: ")
                .append(String.format("%.2f", statistics.getAverageLength()))
                .append(String.format(" characters%n"));
        for (String word : statistics.getAllUniqueWords()) {
            sb.append(word);
            sb.append(String.format("%n"));
        }

        System.out.println(sb.toString());
    }
}
