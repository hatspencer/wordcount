package at.george.interview.domain.filter;

import java.util.List;

public interface WordFilter {

    List<String> filterWords(String inputText);

}
