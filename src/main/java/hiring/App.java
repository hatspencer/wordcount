package hiring;

import java.util.Scanner;

public class App {
	public static void main(String[] args) {

		InputTextReader inputTextReader = new InputTextReader();
		String inputText = inputTextReader.readInputText();

		WordCounter wordCounter = new WordCounter();
		wordCounter.countWords(inputText);
	}
}
