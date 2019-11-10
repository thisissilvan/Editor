package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.List;

/**
 * The Parser class is responsible for parsing user input into Commands and text components
 *
 * @author Ala
 * @version 2019-11-09
 */
public class Parser {

    /**
     * @param input Enthält den Text, der auf Commands untersucht werden soll
     * @return Command Liefert den erkannten Command zurück oder Command.UNKNOWN,
     * falls kein gültiger Befehl gefunden werden konnte
     */
    public ParsedInput parseInput(String input) {
        // extract command
        Command command = extractCommand(input);
        if(Command.UNKNOWN.equals(command)) {
            return new ParsedInput(input, command, new ArrayList<>());
        }

        // extract parameter
        List<String> parameters = extractParameter(input, command);

        // extract text
        String text = extractText(input, command, parameters);

        // create ParsedInput and return
        return new ParsedInput(text, command, parameters);
    }

    private List<String> extractParameter(String input, Command command) {
        List<String> result = new ArrayList<>();
        String text = input.substring(command.getCommand().length() + 1);
        int count = command.getParameterCount();
        for (int i = 0; i < count; i++) {
            int nextSpace = text.indexOf(" ");
            result.add(text.substring(0, nextSpace));
            text = text.substring(nextSpace + 1);
        }

        return result;
    }

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
     * @param input User input with command and text
     * @param parameters List of parameters for the command
     * @return String Only the text without command will be returned, if no command can  be found,
     * empty String will be returned
     */
    public String extractText(String input, Command command, List<String> parameters) {
        int index = command.getCommand().length() + 1;
        for( String parameter: parameters ) {
            index += parameter.length() + 1;
        }

        return input.substring(index);
    }
}
