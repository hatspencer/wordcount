package sk.linhard.wc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.print("Enter text: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String input = reader.readLine();
			Reader inputReader = new StringReader(input);
			WordCounter wordCounter = new WordCounter(inputReader);
			int count = wordCounter.count();
			System.out.print("Number of words: " + count);
		} catch (Throwable e) {
			System.err.println("ERROR: " + e.getMessage());
		}
	}
}
