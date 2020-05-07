package word.match.impl;

import word.match.WordFilter;

public class AzWordFilterImpl implements WordFilter {

    @Override
    public boolean filter(String word) {
        return word != null && hasOnlyAzChars(word);
    }

    private boolean hasOnlyAzChars(String str) {
        return str.matches("([a-z]|[A-Z])+");
    }
}
