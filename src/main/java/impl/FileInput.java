package impl;

import api.InputProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileInput implements InputProvider {

	private String fileName;

	public FileInput(String fileName) {
		this.fileName = fileName;
		if (fileName == null || fileName.trim().isEmpty()) {
			throw new IllegalArgumentException("Filename cannot be empty.");
		}
	}

	@Override
	public String getInput() {
		StringBuilder input = new StringBuilder();
		String line;

		try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
			while ((line = reader.readLine()) != null) {
				input.append(line);
				input.append('\n');
			}
		} catch (FileNotFoundException e) {
			System.err.println("File with provided name '" + fileName + "' was not found.");
			throw new RuntimeException(e);
		} catch (IOException e) {
			System.err.println("Failed to read input from file '" + fileName + "'.");
			throw new RuntimeException(e);
		}

		return input.toString();
	}
}