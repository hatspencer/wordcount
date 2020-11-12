import java.util.Collections;
import java.util.List;

public class WordCount {

    private UserInputImpl userInput;
    private ProcessUserInputImpl processUserInput;

    public WordCount(UserInputImpl userInput, ProcessUserInputImpl processUserInput) {
        this.userInput = userInput;
        this.processUserInput = processUserInput;
    }

    public void wordCount (){
        System.out.print("Enter text: ");
        String userGivenInput = userInput.receiveSystemInput();
        List<String> userWord = processUserInput.processUserInput(userGivenInput);
        System.out.print("Number of words:" + userWord.size());
    }
}
