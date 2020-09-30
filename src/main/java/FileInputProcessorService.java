import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileInputProcessorService implements InputProcessorService {

    static final String CLASSPATH_PREFIX = "classpath://";

    private String filename;

    public FileInputProcessorService(String filename) {
        this.filename = filename;
    }


    @Override
    public String prepareTextInput() {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            File file;
            if (filename.startsWith(CLASSPATH_PREFIX)) {
                try {
                    String realFilename = filename.substring(CLASSPATH_PREFIX.length());
                    ClassLoader classLoader = getClass().getClassLoader();
                    file = new File(classLoader.getResource(realFilename).getFile());
                } catch (Exception e) {
                    throw new FileNotFoundException();
                }
            } else {
                file = new File(filename);
            }

            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                stringBuilder.append(" ")
                        .append(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not Found");
            throw new RuntimeException("File not found");
        }
        return stringBuilder.toString().trim();
    }
}
