package input;

public class UserInputFactory {

    public static UsersInput getUserInput(String from) {
        if (from == null || from.equals("")) {
            return new ConsoleUserInput();
        } else {
            return new FileUserInput(from);
        }
    }
}
