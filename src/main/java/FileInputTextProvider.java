import java.io.*;

public class FileInputTextProvider implements InputTextProvider {

    private final String fileLocation;

    public FileInputTextProvider(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    @Override
    public String getInput() {
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileLocation)))) {
            String line;
            StringBuilder sb = new StringBuilder();
            boolean firstRow = true;
            while ((line = reader.readLine()) != null) {
                if (!firstRow) {
                    sb.append('\n').append(line);
                } else {
                    sb.append(line);
                    firstRow = false;
                }
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileLocation + " not found");
            throw new WordCountException("File " + fileLocation + " not found");
        } catch (IOException e) {
            System.out.println("Error during reading from file: " + fileLocation + e.getMessage());
            throw new WordCountException("IO exception during reading file", e);
        }
    }
}
