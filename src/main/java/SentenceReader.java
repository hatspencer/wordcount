import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public final class SentenceReader {

    private final WordCounter wordCounter = new WordCounter();


    public List<String> read(final String[] args) throws IOException {
        final Scanner in = new Scanner(System.in);
        final boolean isNoParameter = args == null || args.length == 0;

        if (isNoParameter) {

            while (in.hasNextLine()) {
                final String line = in.nextLine();
                countWords(wordCounter, line);
            }

        } else if (args.length == 1) {
            final String fileName = args[0];

            if (!isFileName(fileName)) {
                throw new NoSuchFileException("No file: " + fileName);
            }

            final Path dataFile = Paths.get(fileName);
            final List<String> lines = Files.readAllLines(dataFile, StandardCharsets.UTF_8);
            final String fileWords = String.join(" ", lines);

            countWords(wordCounter, fileWords);
        }

        return Collections.emptyList();
    }

    private static void countWords(final WordCounter wordCounter, final String line) {
        final long count = wordCounter.count2(line);
        System.out.println("Count: " + count);
    }

    private static boolean isFileName(final String firstLine) {
        final Path path = Paths.get(firstLine);
        final File file = path.toFile();

        return file.exists() && !file.isDirectory();
    }

}
