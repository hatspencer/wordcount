package impl;

import api.InputProvider;

import java.util.Scanner;

public class ConsoleInput implements InputProvider {

	public String getInput() {
		System.out.println("Enter text:");
		return new Scanner(System.in).nextLine();
	}
}
