package input;

public class UserInputFactory {

    public static UsersInput getUserInput(String from) {
        if(from==null){
            return new ConsoleUserInput();
        }
        switch (from) {
            case "":
                return new ConsoleUserInput();
            default:
                return new FileUserInput(from);
        }
    }
}
