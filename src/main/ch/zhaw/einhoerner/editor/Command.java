package ch.zhaw.einhoerner.editor;

/**
 * The enum class Command is part of the Editor application.
 *
 * Objects in this class holding the information of the given commands which a user types in the console.
 * A valid command consists of two parts: A command and a String (for example: the command "add 4" consists
 * of the command "add" and the String "4")
 *
 * Commands are getting verified from the program. If an invalid command is given, the command is <null>.
 *
 * If the command only exists one word, the second word is <null>.
 *
 * @author  Gruppe_Einhoerner
 * @version 2019-11-15
 */
public enum Command {
    ADD_EXAMPLETEXT("add exampletexts", 0),
    ADD_INDEX("add index", 2),
    ADD("add", 1),
    PRINT_WIDTH("print width", 1),
    PRINT("print", 0),
    SEARCH_AND_REPLACE("search and replace", 3),
    HELP("help", 0),
    QUIT("quit", 0),
    DELETE("delete", 1),
    UNKNOWN("?", 0),
    MAKE_WORD_INDEX("make word index", 0);


    private String command;
    private int parameterCount;

    /**
     * Initialise constructor with a given command.
     * @param command The command as String value
     */
    Command(String command, int parameterCount) {
        this.command = command;
        this.parameterCount = parameterCount;
    }

    /**
     * Gives back the command.
     * @return The command as String value.
     */
    public String getCommand() {
        return command;
    }

    /**
     * Gives back the parameter count.
     * @return The parameter count from the given command.
     */
    public int getParameterCount() {
        return parameterCount;
    }
}