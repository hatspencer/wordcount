import java.util.Scanner;

public class StandardInputProcessorService implements InputProcessorService{

    @Override
    public String prepareTextInput() {
        System.out.print("Enter text: ");

        Scanner scanner = new Scanner(System.in);
        String inputText = scanner.nextLine();
        scanner.close();

        return inputText;
    }
}
