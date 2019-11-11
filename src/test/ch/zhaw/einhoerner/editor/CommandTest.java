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



}