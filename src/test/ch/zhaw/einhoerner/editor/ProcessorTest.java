package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.lineSeparator;
import static org.junit.jupiter.api.Assertions.*;



class ProcessorTest {

    private String helpMesseage = "Type in " + Command.HELP + " at any time for a short manual. " +
            lineSeparator() + lineSeparator() + "You can choose from the following commands:" + lineSeparator() +
            "add (with or without paragraph number), print, quit, help, searchAndReplace" +
            "(followed by the old and the new word" + lineSeparator() + lineSeparator() +
            "For a manual in detail, please use the Wiki in the Github repository.";

    private String welcomeMesseage = "Welcome to the Editor Application from the team Einhoerner, please use one of the " +
            "following comands to proceed:";

    private String quitMesseage = "Thank you for using the Einhoerner Editor.";
    private String wrongText = "this is not the right messeage";

    private Processor processor;

    private ByteArrayOutputStream consoleContent = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp()
    {
        processor = new Processor();
        System.setOut(new PrintStream(this.consoleContent));
    }


    @Test
    public void printHelpMesseage()
    {
        processor.printText(helpMesseage);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(helpMesseage + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void printWelcomeMesseage()
    {
        processor.printText(welcomeMesseage);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(welcomeMesseage + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void printQuitMesseage()
    {
        processor.printText(quitMesseage);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(quitMesseage + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void printNothing()
    {
        processor.printText(null);
        assertNotEquals(wrongText + lineSeparator(), this.consoleContent.toString());
        assertEquals(null + lineSeparator(), this.consoleContent.toString());
    }

    @Test
    public void makeWelcomeMesseage()
    {
        String welcomeText = processor.makeWelcomeMesseage();

        assertEquals(welcomeMesseage, welcomeText);
        assertNotEquals(welcomeMesseage, wrongText);
    }

    @Test
    public void makeHelpMesseage()
    {
        String helpText = processor.makeHelpMesseage();

        assertEquals(helpMesseage, helpText);
        assertNotEquals(helpMesseage, wrongText);
    }

    @Test
    public void makeQuitMesseage()
    {
        String quitText = processor.makeQuitMesseage();

        assertEquals(quitMesseage, quitText);
        assertNotEquals(quitMesseage, wrongText);
    }
}