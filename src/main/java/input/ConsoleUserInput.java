package input;

import java.util.List;

class ConsoleUserInput implements UsersInput {
    public List<String> getInput() {
        System.out.print("Enter text: ");
        return InputUtils.readFromConsole();
    }
}
