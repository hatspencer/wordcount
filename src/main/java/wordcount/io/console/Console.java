package wordcount.io.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Console implements ConsoleInterface {

	public String getInput(String message) throws IOException {
		System.out.print(message);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		return reader.readLine();
	}

	public void write(String message) {
		System.out.println(message);
	}

}
