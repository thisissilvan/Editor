package ch.zhaw.einhoerner.editor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {


    @Test
    public void testHelp()
    {
        String helpCommand = Command.HELP.getCommand();
        int parameterCountHelp = Command.HELP.getParameterCount();

        assertNotEquals(Command.valueOf("UNKNOWN"), Command.HELP);
        assertEquals(Command.valueOf("HELP"), Command.HELP);
        assertEquals("help", helpCommand);
        assertEquals(0, parameterCountHelp);
    }

    @Test
    public void testAdd()
    {
        String addCommand = Command.ADD.getCommand();
        int parameterCountAdd = Command.ADD.getParameterCount();

        assertNotEquals(Command.valueOf("UNKNOWN"), Command.ADD);
        assertEquals(Command.valueOf("ADD"), Command.ADD);
        assertEquals("add", addCommand);
        assertEquals(1, parameterCountAdd);
    }

    @Test
    public void testExampletext()
    {
        String addExampletextCommand = Command.ADD_EXAMPLETEXT.getCommand();
        int parameterCountAddExampletext = Command.ADD_EXAMPLETEXT.getParameterCount();

        assertNotEquals(Command.valueOf("UNKNOWN"), Command.ADD_EXAMPLETEXT);
        assertEquals(Command.valueOf("ADD_EXAMPLETEXT"), Command.ADD_EXAMPLETEXT);
        assertEquals("add exampletext", addExampletextCommand);
        assertEquals(0, parameterCountAddExampletext);
    }

    @Test
    public void testPrint()
    {
        String printCommand = Command.PRINT.getCommand();
        int parameterCountPrint = Command.PRINT.getParameterCount();

        assertNotEquals(Command.valueOf("UNKNOWN"), Command.PRINT);
        assertEquals(Command.valueOf("PRINT"), Command.PRINT);
        assertEquals("print", printCommand);
        assertEquals(0, parameterCountPrint);
    }

    @Test
    public void testSearchAndReplace()
    {
        String searchAndReplaceCommand = Command.SEARCH_AND_REPLACE.getCommand();
        int parameterCountSearchAndReplace = Command.SEARCH_AND_REPLACE.getParameterCount();

        assertNotEquals(Command.valueOf("UNKNOWN"), Command.SEARCH_AND_REPLACE);
        assertEquals(Command.valueOf("SEARCH_AND_REPLACE"), Command.SEARCH_AND_REPLACE);
        assertEquals("search and replace", searchAndReplaceCommand);
        assertEquals(3, parameterCountSearchAndReplace);
    }

    @Test
    public void testPrintWidth()
    {
        String printWidthCommand = Command.PRINT_WIDTH.getCommand();
        int parameterCountPrintWidth = Command.PRINT_WIDTH.getParameterCount();

        assertNotEquals(Command.valueOf("UNKNOWN"), Command.PRINT_WIDTH);
        assertEquals(Command.valueOf("PRINT_WIDTH"), Command.PRINT_WIDTH);
        assertEquals("print width", printWidthCommand);
        assertEquals(1, parameterCountPrintWidth);
    }

    @Test
    public void testQuit()
    {
        String quitCommand = Command.QUIT.getCommand();
        int parameterCountQuit = Command.QUIT.getParameterCount();

        assertNotEquals(Command.valueOf("UNKNOWN"), Command.QUIT);
        assertEquals(Command.valueOf("QUIT"), Command.QUIT);
        assertEquals("quit", quitCommand);
        assertEquals(0, parameterCountQuit);
    }

    @Test
    public void testUnknown()
    {
        String unknownCommand = Command.UNKNOWN.getCommand();
        int parameterCountUnknown = Command.UNKNOWN.getParameterCount();

        assertNotEquals(Command.valueOf("ADD"), Command.UNKNOWN);
        assertEquals(Command.valueOf("UNKNOWN"), Command.UNKNOWN);
        assertEquals("?", unknownCommand);
        assertEquals(0, parameterCountUnknown);
    }
}