package ch.zhaw.einhoerner.editor;

import java.util.List;

/**
 *  This class holds all information that was parsed from a user input. It consists of
 *  - a command that has been detected from the user input
 *  - the command's parameter list (can be empty)
 *  - an (optional) text which follows the last parameter
 *
 * Examples:
 *  - add 1 Hello world one two three   will be parsed into
 *          - the command "add"
 *          - a list of parameters containing one parameter "1"
 *          - the text "Hello world one two three"
 *  - help                              will be parsed into
 *          - the command "help"
 *          - an empty list of parameters
 *          - an empty String for the text body
 *
 *
 * @author  Ala Hadi, Silvan Luethy
 * @version 2019_11_09
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
     * @return
     */
    public Command getCommand()
    {
        return command;
    }
    /**
     * @return
     */
    public List<String> getParameters()
    {
        return parameters;
    }

    public String getText() {
        return text;
    }
}
