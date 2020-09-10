package hiring.input;

import hiring.TextSupplier;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class ConsoleTextProvider implements TextSupplier {

    @Override
    public void supplyText(Consumer<String> textConsumer) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.print("Enter text: ");
                String line = reader.readLine();
                if (!line.isEmpty()) {
                    textConsumer.accept(line);
                } else {
                    break;
                }
                System.out.println();
            }
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }
}
