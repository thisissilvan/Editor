package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ParserTest {

    @Test
    public void testPrintCommand() {
        String input = "print something something example";
        Command actual = new Parser().parseInput(input);
        Command expected = Command.PRINT;

        assertThat("expected command was print", actual, is(expected));
    }

    @Test
    public void testAddCommand() {
        String input = "add something something example";
        Command actual = new Parser().parseInput(input);
        Command expected = Command.ADD;

        assertThat("expected command was add", actual, is(expected));
    }

    @Test
    public void testNullObject() {
        String input = null;
        Command actual = new Parser().parseInput(input);
        Command expected = Command.UNKNOWN;

        assertThat("expected command was UNKNOWN", actual, is(expected));

    }

    @Test
    public void testEmptyInput() {
        String input = "";
        Command actual = new Parser().parseInput(input);
        Command expected = Command.UNKNOWN;

        assertThat("expected command was UNKNOWN", actual, is(expected));

    }

    @Test
    public void testUnknownCommand() {
        String input = "no command text something something example";
        Command actual = new Parser().parseInput(input);
        Command expected = Command.UNKNOWN;

        assertThat("expected command was UNKNOWN", actual, is(expected));

    }
}