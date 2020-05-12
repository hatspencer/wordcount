package at.george.interview;

import at.george.interview.domain.IO;
import at.george.interview.infrastructure.CommandLineIO;
import at.george.interview.infrastructure.FileReaderIO;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;

public class StarterTest {

    @Test
    public void dispatchToCommandLineIOIfNothingIsPassed() {
        IO io = new Starter().dispatchToIO(new String[0]);

        assertThat(io, instanceOf(CommandLineIO.class));
    }

    @Test
    public void dispatchToFileReaderIOIfFilenameExists() {
        IO io = new Starter().dispatchToIO(new String[]{"somefile.txt"});

        assertThat(io, instanceOf(FileReaderIO.class));
    }

}