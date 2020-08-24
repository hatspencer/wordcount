package at.george.wordcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    void test() {
        final App foo = new App();
        assertEquals("string", foo.test());
    }
}
