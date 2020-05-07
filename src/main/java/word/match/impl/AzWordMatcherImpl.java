package word.match.impl;

import word.match.WordMatcher;

public class AzWordMatcherImpl implements WordMatcher {

    @Override
    public boolean match(String word) {
        return word != null && hasOnlyAzChars(word);
    }

    private boolean hasOnlyAzChars(String str) {
        return str.matches("([a-z]|[A-Z])+");
    }
}
