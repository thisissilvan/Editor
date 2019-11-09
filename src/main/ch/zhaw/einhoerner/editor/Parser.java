package ch.zhaw.einhoerner.editor;

public class Parser {

    /**
     * @param input Enthält den Text, der auf Commands untersucht werden soll
     * @return Command Liefert den erkannten Command zurück oder Command.UNKNOWN,
     * falls kein gültiger Befehl gefunden werden konnte
     */
    public Command parseInput(String input) {
        if (input == null || input.isEmpty()){
            return Command.UNKNOWN;
        }

        for(Command command : Command.values()) {
            if (input.startsWith(command.getCommand())) {
                return command;
            }
        }

        return Command.UNKNOWN;
    }

    public String extractText(String input) {
        Command command = parseInput(input);
        if (Command.UNKNOWN.equals(command)) {
            return "";
        }

        return input.substring(command.getCommand().length() + 1);
    }
}
