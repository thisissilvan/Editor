package ch.zhaw.einhoerner.editor;

import java.util.List;

/**
 * The class Processor.
 *
 *
 * //todo Javadoc
 *
 *
 */
public class Processor {

    private TextOutput textOutput = new TextOutput();
    private Paragraphs paragraphs;
    private List<Paragraphs> allParagraphs;

    /**
     * Constructor of the class Processor.
     */
    public Processor()
    {
        //todo Empty yet
    }

    /**
     * Public method used by the main method to start the editor.
     */
    public void startEditor()
    {
        startApplication();
    }

    /**
     * The private method startApplication prints out a welcome Text. While the user is not typing in the command
     * quit, it is not stopping running.
     */
    private void startApplication()
    {
        printWelcomeText();
        System.out.print("> ");

        boolean quit = false;
        while (!quit) {
            //todo do something and condition for finishing the loop,
            // can be implemented as soon as the commandClass is ready
        }
        System.out.println("Thank you for using the Einhoerner Editor.");
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
        System.out.println("You can choose from the following commands:");
        System.out.println("add (with or without paragraph number), print, quit, help, searchAndReplace (followed by the old and the new word");
        System.out.print("For a manual in detail, please use the Wiki in the Github repository.");
        System.out.println();
    }
}

