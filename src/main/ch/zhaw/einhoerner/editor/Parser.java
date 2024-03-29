package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Parser class is responsible for parsing user input into Commands and text components
 *
 * @author Gruppe_Einhoerner
 * @version 2019-11-15
 */
public class Parser {

    /**
     * The method parsedInput checks if a given command is known by the application and returns
     * it.
     *
     * @param input the command to check for
     * @return Command gives back the actual command or command.UNKNOWN for a unknown command
     */
    public ParsedInput parseInput(String input) {
        // extract command
        Command command = extractCommand(input);
        if (Command.UNKNOWN.equals(command)) {
            return new ParsedInput(input, command, new ArrayList<>());
        }

        // if the input consists only of the command, don't parse parameters
        if (input.length() == command.getCommand().length()) {
            return new ParsedInput("", command, new ArrayList<>());
        }

        // extract parameter
        List<String> parameters = extractParameter(input, command);

        // extract text
        String text = extractText(input, command);

        // create ParsedInput and return
        return new ParsedInput(text, command, parameters);
    }

    /**
     * This method extracts a command's parameters from the user's input, if there are any.
     *
     * - The algorithm first removes the detected command within the user's input (e.g. PRINT)
     * - Next the algorithm detects the command's expected parameter count N (e.g. N=1) and
     *   removes N words from the beginning of the user's input. Each word will be added to
     *   list of parameters for the detected command
     * - the list of commands will now be returned
     *
     * @param input   The user's input consisting of a command, potential parameters of this command and an optional text body
     * @param command The detected command in the user's input
     * @return List<String> A List<String> of commands
     */
    private List<String> extractParameter(String input, Command command) {
        List<String> result = new ArrayList<>();
        String text = input.substring(command.getCommand().length() + 1);
        int count = command.getParameterCount();
        int nextSpace = text.indexOf(" ");

        if (count >1){
            for (int i = 0; i < count-1; i++) {
                result.add(text.substring(0, nextSpace));
                text = text.substring(nextSpace + 1);
                nextSpace = text.indexOf(" ");
            }
            result.add(text);
        }else{
            result.add(text);
        }
        return result;
    }
    /**
     * This method scans the user's input for a command. The algorithm expects
     * the input to start with a valid command. If no such command can be found,
     * Command.UNKNOWN will be returned instead.
     *
     * @param input The user's input in which the command is to be found
     * @return Command  The Command which was found in the user's input
     *                  or Command.UNKNOWN if no command could be found
     */
    private Command extractCommand(String input) {
        if (input == null || input.isEmpty()) {
            return Command.UNKNOWN;
        }

        for (Command command : Command.values()) {
            if (input.startsWith(command.getCommand())) {
                return command;
            }
        }
        return Command.UNKNOWN;
    }

    /**
     * Extracts the text content without the command
     *
     * @param input      User input with command and text
     * @return String Only the text without command will be returned, if no command can  be found,
     * empty String will be returned
     */
    public String extractText(String input, Command command) {
        return input.substring(command.getCommand().length() + 1);
    }
}
