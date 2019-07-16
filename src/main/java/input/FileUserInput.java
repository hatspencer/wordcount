package input;

import java.util.List;

class FileUserInput implements UsersInput {
    protected String from;
    public FileUserInput(String from) {
        this.from = from;
    }

    public List<String> getInput() {
        return InputUtils.readFromFile(this.from);
    }
}
