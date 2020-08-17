import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);
        final WordCounter wordCounter = new WordCounter();

        if (in.hasNextLine()) {
            final String firstLine = in.nextLine();

            if (isInvalidFile(firstLine)) {

            }

            final int count = wordCounter.count(firstLine);
            System.out.println("Count: " + count);
        }

    }

    private static boolean isInvalidFile(final String firstLine) {
        return false;
    }

}
