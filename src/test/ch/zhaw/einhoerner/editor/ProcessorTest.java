package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.*;


class ProcessorTest {

    private String helpMesseage = "Type in " + Command.HELP + " at any time for a short manual.\n\n " +
            "You can choose from the following commands:\n" +
            "add (with or without paragraph number), print, quit, help, searchAndReplace" +
            "(followed by the old and the new word \n\n" +
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
        assertNotEquals(wrongText + "\n", this.consoleContent.toString());
        assertEquals(helpMesseage + "\n", this.consoleContent.toString());
    }

    @Test
    public void printWelcomeMesseage()
    {
        processor.printText(welcomeMesseage);
        assertNotEquals(wrongText + "\n", this.consoleContent.toString());
        assertEquals(welcomeMesseage + "\n", this.consoleContent.toString());
    }

    
}