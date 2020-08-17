import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        final Scanner in = new Scanner(System.in);
        final WordCounter wordCounter = new WordCounter();

        while (in.hasNextLine()) {
            final String line = in.nextLine();
            final int count = wordCounter.count(line);
            System.out.println("Count: " + count);
        }

    }

}
