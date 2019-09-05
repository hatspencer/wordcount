package at.flwal.erste.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintStream;

public class TestIO implements Closeable {

	public ByteArrayInputStream inputStream;
	public ByteArrayOutputStream buffer;
	public PrintStream outputStream;

	public static TestIO createIO(String input) {
		TestIO testIO = new TestIO();
		testIO.inputStream = new ByteArrayInputStream(input.getBytes());
		testIO.buffer = new ByteArrayOutputStream();
		testIO.outputStream = new PrintStream(testIO.buffer);
		return testIO;
	}

	@Override
	public void close() throws IOException {
		inputStream.close();
		outputStream.close();
		buffer.close();
	}

}
