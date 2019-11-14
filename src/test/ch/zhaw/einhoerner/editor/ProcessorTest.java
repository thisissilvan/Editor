package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();

    /**
     * ByteArrayOutputStream is a concept which we not discussed yet, however to test the actual console outcome, we need
     * this.
     */
    @BeforeEach
    public void setUp() {
        processor = new Processor();
        System.setOut(new PrintStream(this.consoleContent));
    }

    /**
     * Print the help messeage to the cosole and test the actual outcome.
     */
    @Test
    public void printHelpMessage()
    {
        processor.printText(helpMessage);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(helpMessage + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void printWelcomeMessage()
    {
        processor.printText(welcomeMessage);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(welcomeMessage + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void printQuitMessage()
    {
        processor.printText(quitMessage);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(quitMessage + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void printNothing()
    {
        processor.printText(null);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(null + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void makeWelcomeMessage()
    {
        String welcomeText = processor.getWelcomeMessage();

        assertEquals(welcomeMessage, welcomeText);
        assertNotEquals(welcomeMessage, wrongText);
    }

    @Test
    public void makeHelpMessage()
    {
        String helpText = processor.getHelpMessage();

        assertEquals(helpMessage, helpText);
        assertNotEquals(helpMessage, wrongText);
    }

    @Test
    public void makeQuitMessage()
    {
        String quitText = processor.getQuitMessage();

        assertEquals(quitMessage, quitText);
        assertNotEquals(quitMessage, wrongText);
    }

    @Test
    public void addTextWithIndex() {
        processor.add("0");
        processor.add("1");
        processor.add(1, "hallo");
        assertEquals("hallo", processor.get(1));
        assertEquals("1", processor.get(2));
    }
    @Test
    public void addTest(){
        processor.add("joking");
        assertEquals("joking", processor.get(0));
        processor.add("joking1");
        assertEquals("joking1", processor.get(1));
    }
    @Test
    public void deleteTest(){
        processor.add("0");
        processor.add("1");
        processor.delete(0);
        assertEquals("1", processor.get(0));
    }
    @Test
    public void searchAndReplaceTest(){
        processor.add("a b a b a b a b");
        processor.add("1");
        processor.searchAndReplace(0, "a", "c");
        assertEquals("c b c b c b c b", processor.get(0));
    }
    void testExampleText() {
        Processor p = new Processor();
        String input = "add_exampletext";

        ParsedInput parsedInput = new Parser().parseInput(input);
        assertThat("Processor should not have any paragraphs", 0, is(p.getParagraphs().size()));
        p.executeCommand(parsedInput);
        assertThat("Processor should have 5 paragraphs after adding the example text.", 5, is(p.getParagraphs().size()));
    }




}