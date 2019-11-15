package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
    public void testExtractionPrint() {
        String input = "print something something example";
        String actual = new Parser().parseInput(input).getText();
        String expected = "something something example";

        assertThat("text should be: something something example", actual, is(expected));
    }

    @Test
    public void testExtractionAdd() {
        String input = "add something something example";
        String actual = new Parser().parseInput(input).getText();
        String expected = "something something example";

        assertThat("text should be: something something example", actual, is(expected));
    }


    @Test
    public void testExtractionEmptyInput() {
        String input = "";
        String actual = new Parser().parseInput(input).getText();
        String expected = "";

        assertThat("text should be empty", actual, is(expected));
    }

    @Test
    public void testCommandWithoutParameter() {
        String input = "help";
        List<String> actual = new Parser().parseInput(input).getParameters();
        List<String> expected = new ArrayList<>();

        assertThat("there should be no parameters", actual, is(expected));
    }

    @Test
    public void testCommandWithThreeParameters() {
        String input = "search and replace 1 kartoffel tomate";
        List<String> actual = new Parser().parseInput(input).getParameters();
        List<String> expected = Arrays.asList("1", "kartoffel", "tomate");

        assertThat("there should be 3 parameters", actual, is(expected));
    }

    @Test
    public void testCommandWithTwoParameters() {
        String input = "add index 3 beispiel text";
        List<String> actual = new Parser().parseInput(input).getParameters();
        List<String> expected = Arrays.asList("3", "beispiel text");

        assertThat("there should be 2 parameters", actual, is(expected));
    }
    
    @Test
    public void testCommandWithOneParameter() {
        String input = "add beispiel text";
        List<String> actual = new Parser().parseInput(input).getParameters();
        List<String> expected = Collections.singletonList("beispiel text");

        assertThat("there should be just one parameter", actual, is(expected));
    }
}