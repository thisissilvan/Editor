package ch.zhaw.einhoerner.editor;

import java.util.List;

/**
 * The class ParsedInput is part of the Editor application.
 *
 * Objects in this class holding the information of the given commands which a user types in the console.
 * A valid command consists of two parts: A command and an optional String (for example: the command "add 4" consists
 * of the command "add" and the String "4")
 *
 * Commands are getting verified from the program. If an invalid command is given, the command is <null>.
 *
 * If the command does not need a parameter, it can be empty.
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
