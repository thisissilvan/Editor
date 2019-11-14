package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.System.lineSeparator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.CoreMatchers.is;



class ProcessorTest {
    private String helpMessage = "Type in " + Command.HELP + " at any time for a short manual. " +
            lineSeparator() + lineSeparator() + "You can choose from the following commands:" + lineSeparator() +
            "add (with or without paragraph number) <text>, add_exampletext, print, " +
            "print_width (with width in character count), delete, quit, help, search_and_replace" +
            "(followed by the old and the new word)" + lineSeparator() + lineSeparator() +
            "For a manual in detail, please use the Wiki in the Github repository.";

    private String welcomeMessage = "Welcome to the Editor Application from the team Einhoerner, please use one of the " +
            "following comands to proceed:";

    private String quitMessage = "Thank you for using the Einhoerner Editor.";
    private String wrongText = "this is not the right message";

    private Processor processor;


    @BeforeEach
    public void setUp()
    {
        processor = new Processor();
    }

    @Test
    public void getWelcomeMessage()
    {
        String welcomeText = processor.getWelcomeMessage();

        assertEquals(welcomeMessage, welcomeText);
        assertNotEquals(welcomeMessage, wrongText);
    }

    @Test
    public void getHelpMessage()
    {
        String helpText = processor.getHelpMessage();

        assertEquals(helpMessage, helpText);
        assertNotEquals(helpMessage, wrongText);
    }

    @Test
    public void getQuitMessage()
    {
        String quitText = processor.getQuitMessage();

        assertEquals(quitMessage, quitText);
        assertNotEquals(quitMessage, wrongText);
    }

    @Test
    void testExampleText() {
        Processor p = new Processor();
        String input = "add exampletext";

        ParsedInput parsedInput = new Parser().parseInput(input);
        assertThat("Processor should not have any paragraphs", 0, is(p.getParagraphs().size()));
        p.executeCommand(parsedInput);
        assertThat("Processor should have 5 paragraphs after adding the example text.", 5, is(p.getParagraphs().size()));
    }

}