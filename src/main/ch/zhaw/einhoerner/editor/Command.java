package ch.zhaw.einhoerner.editor;

/**
 * The class Command is part of the Editor application.
 *
 * Objects in this class holding the information of the given commands which a user types in the console.
 * A valid command consists of two parts: A command and a String (for example: the command "add 4" consists
 * of the command "add" and the String "4")
 *
 * Commands are getting verified from the program. If an invalid command is given, the command is <null>.
 *
 * If the command only exists one word, the second word is <null>.
 *
 * @author  Silvan,
 * @version 2019_11_09
 */
public enum Command {
    ADD_EXAMPLETEXT("add exampletext"), ADD("add"), PRINT("print"),
    SEARCH_AND_REPLACE("search and replace"), PRINT_WIDTH("print width"),
    HELP("help"), QUIT("quit"), UNKNOWN("?");


    private String command;

    /**
     * Initialise constructor with a given command.
     *
     * @param command The command as String value
     */
    Command(String command) {
        this.command = command;
    }

    /**
     * Gives back the command.
     *
     * @return The command as String value.
     */
    public String getCommand() {
        return command;
    }

}