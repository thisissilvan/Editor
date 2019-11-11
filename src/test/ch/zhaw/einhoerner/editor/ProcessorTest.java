package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ProcessorTest {

    @Test
    public void testPrintCommand() {
        String input = "print something something example";
        Command actual = new Parser().parseInput(input).getCommand();
        Command expected = Command.PRINT;

        assertThat("expected command was print", actual, is(expected));
    }
}