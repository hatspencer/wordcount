package hiring;

import java.util.function.Consumer;

public interface TextSupplier {

    void supplyText(Consumer<String> textConsumer);
}
