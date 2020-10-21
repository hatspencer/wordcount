package utils.inputresolver;

import dto.inputresolver.CommandLineInputResolverResponseDto;
import org.junit.Test;

import static org.junit.Assert.*;

public class CommandLineInputResolverTest {

    private CommandLineInputResolver commandLineInputResolver = new CommandLineInputResolver();

    @Test
    public void testResolveCommandLineArguments() {
        final String[] withIndexNoFile = new String[]{"-index"};
        final CommandLineInputResolverResponseDto commandLineInputResolverResponseDto =
                commandLineInputResolver.resolveCommandLineArguments(withIndexNoFile);
        assertTrue(commandLineInputResolverResponseDto.isWithIndex());
        assertNull(commandLineInputResolverResponseDto.getFileName());
    }

    @Test
    public void testWithIndexAndFile() {
        final String[] withIndexAndFile = new String[]{"-index", "filename"};
        final CommandLineInputResolverResponseDto commandLineInputResolverResponseDto1 =
                commandLineInputResolver.resolveCommandLineArguments(withIndexAndFile);
        assertTrue(commandLineInputResolverResponseDto1.isWithIndex());
        assertNotNull(commandLineInputResolverResponseDto1.getFileName());
    }

    @Test
    public void testWithIndexAndFileInverted() {
        final String[] withIndexAndFileInverted = new String[]{"filename", "-index"};
        final CommandLineInputResolverResponseDto commandLineInputResolverResponseDto2 =
                commandLineInputResolver.resolveCommandLineArguments(withIndexAndFileInverted);
        assertTrue(commandLineInputResolverResponseDto2.isWithIndex());
        assertNotNull(commandLineInputResolverResponseDto2.getFileName());
    }

    @Test
    public void testNoArguments() {
        final String[] noArguments = new String[]{};
        final CommandLineInputResolverResponseDto commandLineInputResolverResponseDto3 =
                commandLineInputResolver.resolveCommandLineArguments(noArguments);
        assertFalse(commandLineInputResolverResponseDto3.isWithIndex());
        assertNull(commandLineInputResolverResponseDto3.getFileName());
    }

    @Test(expected = RuntimeException.class)
    public void testTooManyArguments() {
        final String[] tooManyArguments = new String[]{"filename", "-index", "filename", "-index"};
        commandLineInputResolver.resolveCommandLineArguments(tooManyArguments);
    }

    @Test
    public void testNoIndex() {
        final String[] noIndex = new String[]{"filename"};
        final CommandLineInputResolverResponseDto commandLineInputResolverResponseDto4 =
                commandLineInputResolver.resolveCommandLineArguments(noIndex);
        assertFalse(commandLineInputResolverResponseDto4.isWithIndex());
        assertNotNull(commandLineInputResolverResponseDto4.getFileName());
    }

    @Test(expected = RuntimeException.class)
    public void testWrongIndexNaming() {
        final String[] wrongIndexNaming = new String[]{"filename", "wrongIndex"};
        commandLineInputResolver.resolveCommandLineArguments(wrongIndexNaming);
    }
}
