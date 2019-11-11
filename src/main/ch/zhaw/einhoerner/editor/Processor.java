package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The class Processor.
 * <p>
 * <p>
 * //todo Javadoc
 */
public class Processor {

    private TextOutput textOutput = new TextOutput();
    private List<String> paragraphs= new ArrayList<>();
    private Parser parser = new Parser();

    /**
     * Constructor of the class Processor.
     */
    public Processor() {
        //todo Empty yet
    }

    /**
     * Public method used by the main method to start the editor.
     */
    public void startApplication() {
        printWelcomeText();
        System.out.print("> ");

        String nextCommand = "";
        while (!Command.QUIT.getCommand().equals(nextCommand)) {

            // retrieve next user input
            String userInput = getUserInput();

            // parse user input
            ParsedInput parsedInput = parser.parseInput(userInput);
            nextCommand = parsedInput.getCommand().getCommand();
            System.out.println("Detected command: " + nextCommand);

            // execute command
            switch (parsedInput.getCommand()) {
                case ADD_EXAMPLETEXT:
                    String generated = addExampleText();
                    // TODO this text has to be saved somehow somewhere
                    break;
                default:
                    break;
            }
        }


        System.out.println("Thank you for using the Einhoerner Editor.");
    }

    private String addExampleText() {
        String text = ExampleText.EXAMPLE_TEXT;
        System.out.println(text);
        return text;
    }

    private String getUserInput() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        return input;
    }

    /**
     * Creates a welcome message which is used from the method startApplication.
     */
    public void printWelcomeText() {
        System.out.println();
        System.out.println("Welcome to the Editor Application from the team Einhoerner");
        System.out.println("Type in " + Command.HELP + " at any time for a short manual.");
        System.out.println();
        System.out.println("Please use one of the following comands to proceed:");
        printHelpText();
    }

    /**
     * Creates a help message to give the user some advice to use the application.
     * Further information and a manual on how to use the application is on the Wiki-Page of the Github repository
     */
    public void printHelpText() {
        System.out.println();
        System.out.print("You can choose from the following commands:" +
                "add (with or without paragraph number), print, quit, help, searchAndReplace (followed by the old and the new word");
        System.out.println();
        System.out.println("For a manual in detail, please use the Wiki in the Github repository.");
        System.out.println();
    }
}

