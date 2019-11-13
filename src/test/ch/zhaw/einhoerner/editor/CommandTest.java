package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommandTest {



    @BeforeEach
    void setUp()
    {
    }

    @AfterEach
    void tearDown()
    {
    }


    @Test
    public void testHelp()
    {
        Command command = Command.HELP;
        String helpCommand = command.HELP.getCommand();
        int parameterCountHelp = command.HELP.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals(Command.valueOf("HELP"), command);
        assertEquals("help", helpCommand);
        assertEquals(0, parameterCountHelp);
    }

    @Test
    public void testAdd()
    {
        Command command = Command.ADD;
        String addCommand = command.ADD.getCommand();
        int parameterCountAdd = command.ADD.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals(Command.valueOf("ADD"), command);
        assertEquals("add", addCommand);
        assertEquals(1, parameterCountAdd);
    }

    @Test
    public void testExampletext()
    {
        Command command = Command.ADD_EXAMPLETEXT;
        String addExampletextCommand = command.ADD_EXAMPLETEXT.getCommand();
        int parameterCountAddExampletext = Command.ADD_EXAMPLETEXT.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals(Command.valueOf("ADD_EXAMPLETEXT"), command);
        assertEquals("add exampletext", addExampletextCommand);
        assertEquals(0, parameterCountAddExampletext);
    }

    @Test
    public void testPrint()
    {
        Command command = Command.PRINT;
        String printCommand = command.PRINT.getCommand();
        int parameterCountPrint = command.PRINT.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals(Command.valueOf("PRINT"), command);
        assertEquals("print", printCommand);
        assertEquals(0, parameterCountPrint);
    }

    @Test
    public void testSearchAndReplace()
    {
        Command command = Command.SEARCH_AND_REPLACE;
        String searchAndReplaceCommand = command.SEARCH_AND_REPLACE.getCommand();
        int parameterCountSearchAndReplace = command.SEARCH_AND_REPLACE.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals(Command.valueOf("SEARCH_AND_REPLACE"), command);
        assertEquals("search and replace", searchAndReplaceCommand);
        assertEquals(3, parameterCountSearchAndReplace);
    }

    @Test
    public void testPrintWidth()
    {
        Command command = Command.PRINT_WIDTH;
        String printWidthCommand = command.PRINT_WIDTH.getCommand();
        int parameterCountPrintWidth = command.PRINT_WIDTH.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals(Command.valueOf("PRINT_WIDTH"), command);
        assertEquals("print width", printWidthCommand);
        assertEquals(1, parameterCountPrintWidth);
    }

    @Test
    public void testQuit()
    {
        Command command = Command.QUIT;
        String quitCommand = command.QUIT.getCommand();
        int parameterCountQuit = command.QUIT.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals(Command.valueOf("QUIT"), command);
        assertEquals("quit", quitCommand);
        assertEquals(0, parameterCountQuit);
    }

    @Test
    public void testUnknown()
    {
        Command command = Command.UNKNOWN;
        String unknownCommand = command.UNKNOWN.getCommand();
        int parameterCountUnknown = command.UNKNOWN.getParameterCount();

        assertNotNull(command);
        assertNotEquals(Command.valueOf("ADD"), command);
        assertEquals(Command.valueOf("UNKNOWN"), command);
        assertEquals("?", unknownCommand);
        assertEquals(0, parameterCountUnknown);
    }

}