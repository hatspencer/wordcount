import java.util.Scanner;

public class UserInputImpl implements UserInput {


    public String receiveSystemInput() {
        String line = null;

        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()){
            line = scanner.nextLine();
        }
        scanner.close();
        return line;
    }
}
