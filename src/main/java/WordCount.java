
import java.util.Collections;
import java.util.List;

public class WordCount {

    private String[] optionalCommands;
    private UserInputImpl userInput;
    private ProcessUserInputImpl processUserInput;

    public WordCount(UserInputImpl userInput, ProcessUserInputImpl processUserInput, String[] optionalCommands) {
        this.userInput = userInput;
        this.processUserInput = processUserInput;
        this.optionalCommands = optionalCommands;
    }

    public void wordCount (){
        String userGivenInput = "";

        if(optionalCommands.length == 0) {
            System.out.print("Enter text: ");
            userGivenInput = userInput.receiveSystemInput();
        } else {
            String userSentenceFileName = optionalCommands[0];
            //TODO getUserInput from by fiven fileName (class processUserInputFile)
        }

        List<String> userWord = processUserInput.processUserInput(userGivenInput);
        System.out.print("Number of words:" + userWord.size());
    }
}
