import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

public final class SentenceReader {

    public String read(final String[] args) throws IOException {
        final boolean isNoParameter = args == null || args.length == 0;
        final boolean isSingleParameter = args != null && args.length == 1;
        String resultSentence = "";

        if (isSingleParameter) {
            final String fileName = args[0];

            if (!isFileName(fileName)) {
                throw new NoSuchFileException("No file: " + fileName);
            }

            final Path dataFile = Paths.get(fileName);
            resultSentence = Files.lines(dataFile, StandardCharsets.UTF_8).collect(Collectors.joining(" "));

        } else if (isNoParameter) {
            System.out.println("Enter text: ");
            final Scanner in = new Scanner(System.in);

            if (in.hasNextLine()) {
                resultSentence = in.nextLine();
            }

        }

        return resultSentence;
    }

    private static boolean isFileName(final String firstLine) {
        final Path path = Paths.get(firstLine);

        return Files.exists(path);
    }

}
