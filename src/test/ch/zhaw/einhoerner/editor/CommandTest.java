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
    public void testHelpCommand()
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
    public void testAddCommand()
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
    public void testExampletextCommand()
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
    public void testPrintCommand()
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

    
}