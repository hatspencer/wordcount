package hiring.filereader;

import java.io.*;

public class TextFileContentReader implements FileContentReader {

	@Override
	public String readFileContent(String filePath) {
		try (InputStream fis = new FileInputStream(filePath);
		     InputStreamReader isr = new InputStreamReader(fis);
		     BufferedReader br = new BufferedReader(isr)) {

			return readFileContent(br);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Failed to open file with path " + filePath, e);
		} catch (IOException e) {
			throw new IllegalArgumentException("Failed to read file on path " + filePath, e);
		}
	}

	private String readFileContent(BufferedReader br) throws IOException {
		StringBuilder fileContent = new StringBuilder("");
		String line;
		while ((line = br.readLine()) != null) {
			fileContent.append(line).append("\n");
		}
		return fileContent.toString();
	}

}
