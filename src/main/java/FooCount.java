import java.util.Arrays;
import java.util.Scanner;

public class FooCount {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter text: ");

        final String textLine = scanner.nextLine();

        final long count = Arrays.stream(textLine.split(" "))
                .filter(it -> !it.isEmpty())
                .count();

        System.out.println("Number of words: " + count);
    }
}
