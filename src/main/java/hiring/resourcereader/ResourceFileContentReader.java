package hiring.resourcereader;

import java.io.*;

public class ResourceFileContentReader implements FileContentReader {

	@Override
	public String readFileContent(String resourceName) {
		try (InputStream fis = openResourceAsInputStream(resourceName);
		     InputStreamReader isr = new InputStreamReader(fis);
		     BufferedReader br = new BufferedReader(isr)) {

			return readFileContent(br);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Failed to open file with path " + resourceName, e);
		} catch (IOException e) {
			throw new IllegalArgumentException("Failed to read file on path " + resourceName, e);
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

	private InputStream openResourceAsInputStream(String resourceName) {
		return getClass().getClassLoader().getResourceAsStream(resourceName);
	}

}
