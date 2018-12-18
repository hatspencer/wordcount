package at.egit.wordcount;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

class LinesReader {

    List<String> readAllLines(String fileName) {
        List<String> lines = new ArrayList<>();
        final URL resource = WordCountApp.class.getClassLoader().getResource(fileName);

        if (resource != null) {
            try {
                final URI uri = resource.toURI();
                lines = Files.readAllLines(Paths.get(uri));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }

        return lines;
    }
}
