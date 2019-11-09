package ch.zhaw.einhoerner.editor;

/**
 * Representation of all valid commands with a given String.
 *
 * @author  Silvan Luethy
 * @version 2019_11_09
 */
public enum EnumCommand
{
    ADD_EXAMPLETEXT("add exampletext"), ADD("add"), PRINT("print"),
    SEARCH_AND_REPLACE("search and replace"), PRINT_WIDTH("print width"), HELP("help"), QUIT("quit"), UNKNOWN("?");

    private String command;

    /**
     * Initialise constructor with a given command.
     * @param command The command as String value
     */
    EnumCommand(String command)
    {
        this.command = command;
    }

    /**
     * Gives back the command.
     * @return  The command as String value.
     */
    public String toString()
    {
        return command;
    }

}