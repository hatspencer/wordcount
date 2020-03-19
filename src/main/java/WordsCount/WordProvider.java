package WordsCount;

import java.util.List;

public class WordProvider {

    public String[] getWords(List<String> texts) {
        return getWords(String.join(" ", texts));
    }


    public String[] getWords(String text) {
        return text.trim().replace(".", "").split("\\s+|-");
    }

}
