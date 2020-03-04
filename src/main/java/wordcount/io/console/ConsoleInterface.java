package wordcount.io.console;

import java.io.IOException;

public interface ConsoleInterface {

	public String getInput(String message)  throws IOException;
	
	public void write(String message);
	
}
