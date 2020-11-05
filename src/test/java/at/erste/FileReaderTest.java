package at.erste;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

public class FileReaderTest {

    @Test(expected = IllegalStateException.class)
    public void testReadFileDoesNotExist() {
        FileReaderImpl fileReader = new FileReaderImpl();

        fileReader.readContentOfFile("nonexisting" + UUID.randomUUID() + ".txt");

    }

    @Test
    public void testReadExistingFile() {
        String fileContent = "This is my content";
        String fileName = "delete_me_" + UUID.randomUUID().toString().concat(".txt");
        FileWriter writer = null;
        File file = new File(fileName);
        try {
            Assert.assertEquals("The file should not exist.",file.exists(), false);

            boolean newFile = file.createNewFile();

            if (newFile) {
                writer = new FileWriter(file);
                writer.append(fileContent);
                writer.close();
            }

            FileReaderImpl reader = new FileReaderImpl();

            String contentOfFile = reader.readContentOfFile(fileName);

            Assert.assertTrue(contentOfFile.startsWith(fileContent));
        } catch (IOException e) {
            System.out.println("Unable to create file " + fileName);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                }
            }
            if (file.exists()) {
               file.delete();
            }
        }



    }


}
