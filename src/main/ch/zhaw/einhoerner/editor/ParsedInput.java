package ch.zhaw.einhoerner.editor;

import java.util.List;

/**
 *  This class holds all information that was parsed from a user input. It consists of
 *  - a command that has been detected from the user input
 *  - the command's parameter list (can be empty)
 *  - an (optional) text which follows the last parameter
 *
 * For an exact manual, please consult the Wiki-Page on our GitHub Repository.
 *
 *
 * @author  Gruppe_Einhoerner
 * @version 2019-11-15
 */
public class ParsedInput {
    private final String text;
    private Command command;
    private List<String> parameters;

    /**
     * @param text The text without command
     * @param command The editor command
     * @param parameters The parameters for the editor command
     */
    public ParsedInput(String text, Command command, List<String> parameters)
    {
        this.command = command;
        this.parameters = parameters;
        this.text = text;
    }

    /**
     * Returns the command.
     * @return The command from the enum class command.
     */
    public Command getCommand()
    {
        return command;
    }

    /**
     * Returns the parameters saved in the command.
     * @return the parameters saved in the given command.
     */
    public List<String> getParameters()
    {
        return parameters;
    }

    /**
     * Returns the text saved in the given command.
     * @return the text from the given command
     */
    public String getText() {
        return text;
    }
}
