package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class ParserTest {

    @Test
    public void testPrintCommand() {
        String input = "print something something example";
        Command actual = new Parser().parseInput(input).getCommand();
        Command expected = Command.PRINT;

        assertThat("expected command was print", actual, is(expected));
    }

    @Test
    public void testAddCommand() {
        String input = "add something something example";
        Command actual = new Parser().parseInput(input).getCommand();
        Command expected = Command.ADD;

        assertThat("expected command was add", actual, is(expected));
    }

    @Test
    public void testNullObject() {
        String input = null;
        Command actual = new Parser().parseInput(input).getCommand();
        Command expected = Command.UNKNOWN;

        assertThat("expected command was UNKNOWN", actual, is(expected));

    }

    @Test
    public void testEmptyInput() {
        String input = "";
        Command actual = new Parser().parseInput(input).getCommand();
        Command expected = Command.UNKNOWN;

        assertThat("expected command was UNKNOWN", actual, is(expected));

    }

    @Test
    public void testUnknownCommand() {
        String input = "no command text something something example";
        Command actual = new Parser().parseInput(input).getCommand();
        Command expected = Command.UNKNOWN;

        assertThat("expected command was UNKNOWN", actual, is(expected));

    }

    @Test
    void testExtractionPrint() {
        String input = "print something something example";
        String actual = new Parser().parseInput(input).getText();
        String expected = "something something example";

        assertThat("unexpected input", actual, is(expected));
    }

    @Test
    void testExtractionAdd() {
        String input = "add 1 something something example";
        String actual = new Parser().parseInput(input).getText();
        String expected = "something something example";

        assertThat("unexpected input", actual, is(expected));
    }


    @Test
    void testExtractionEmptyInput() {
        String input = "";
        String actual = new Parser().parseInput(input).getText();
        String expected = "";

        assertThat("unexpected input", actual, is(expected));
    }
}