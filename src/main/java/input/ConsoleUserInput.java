package input;

import java.util.List;

class ConsoleUserInput extends UsersInput {
    public List<String> getInput() {
        System.out.print("Enter text: ");
        return InputUtils.readFromConsole();
    }
}
