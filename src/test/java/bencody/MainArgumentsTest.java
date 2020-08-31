package bencody;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MainArgumentsTest {

    @Test
    public void should_parse_empty_args() {
        MainArguments mainArguments = MainArguments.createFromArgsArray(new String[]{});

        assertThat(mainArguments.filePath, equalTo(Optional.empty()));
        assertThat(mainArguments.outputIndex, equalTo(false));
    }

    @Test
    public void should_parse_file_arg() {
        MainArguments mainArguments = MainArguments.createFromArgsArray(new String[]{"filePath"});

        MatcherAssert.assertThat(mainArguments.filePath.get(), equalTo("filePath"));
        assertThat(mainArguments.outputIndex, equalTo(false));
    }

    @Test
    public void should_parse_index_arg() {
        MainArguments mainArguments = MainArguments.createFromArgsArray(new String[]{"-wordIndex"});

        assertThat(mainArguments.filePath, equalTo(Optional.empty()));
        assertThat(mainArguments.outputIndex, equalTo(true));
    }

    @Test
    public void should_parse_all_possible_args() {
        MainArguments mainArguments = MainArguments.createFromArgsArray(new String[]{"-wordIndex", "test.txt"});

        MatcherAssert.assertThat(mainArguments.filePath.get(), equalTo("test.txt"));
        assertThat(mainArguments.outputIndex, equalTo(true));

        mainArguments = MainArguments.createFromArgsArray(new String[]{"test.txt", "-wordIndex",}); // Other

        MatcherAssert.assertThat(mainArguments.filePath.get(), equalTo("test.txt"));
        assertThat(mainArguments.outputIndex, equalTo(true));
    }
}
