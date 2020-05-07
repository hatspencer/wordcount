package text.split.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import text.split.TextSplitter;

public class WhiteSpaceTextSplitterImpl implements TextSplitter {

    @Override
    public List<String> split(String text) {
        if (text == null) {
            return new ArrayList<>();
        }

        String[] splitText = text.split("(\\s+|-)+");
        return Arrays.stream(splitText)
                .filter(this::isNotBlank)
                .collect(Collectors.toList());
    }

    private boolean isNotBlank(String str) {
        return !str.isEmpty() && !str.matches("\\s+");
    }
}
