import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wordNumber = 0;
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        scanner.close();
        if (text != null && !text.equals("")) {
            wordNumber = text.trim().split("\\s+").length;
        }
        System.out.print("Number of words: " + wordNumber);
    }
}
