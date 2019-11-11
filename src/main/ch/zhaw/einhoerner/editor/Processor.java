package ch.zhaw.einhoerner.editor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.lineSeparator;

/**
 * The class Processor.
 * <p>
 * <p>
 * //todo Javadoc
 */
public class Processor {

    private Parser parser = new Parser();
    private List<String> paragraphs = new ArrayList<>();
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
        printText(makeWelcomeText());
        printText(makeHelpText());
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

    public void printText(String comand)
    {
        System.out.println(comand);
    }

    /**
     * Creates a welcome message which is used from the method startApplication.
     */

    public String makeWelcomeText() {
        return "Welcome to the Editor Application from the team Einhoerner, please use one of the " +
                "following comands to proceed:";
    }

    private void printWholeText() {
        for(int i=0;i<paragraphs.size(); i++){
            System.out.println(paragraphs.get(i));
            System.out.println();
        }
    }

    /**
     * Creates a help message to give the user some advice to use the application.
     * Further information and a manual on how to use the application is on the Wiki-Page of the Github repository
     */
    public String makeHelpText()
    {
        return "Type in " + Command.HELP + " at any time for a short manual.\n\n " +
                "You can choose from the following commands:\n" +
                "add (with or without paragraph number), print, quit, help, searchAndReplace" +
                "(followed by the old and the new word \n\n" +
                "For a manual in detail, please use the Wiki in the Github repository.";
    }

    /**
     * Print out an unformatted version of all the paragraphs
     * @param paragraphs a List of all Paragraphs stored at the time of ececution
     */
    public void printUnformatted(List<String> paragraphs)
    {
        printWholeText();

    }

    /**
     * Print out a formatted version of all the paragraphs
     * @param width - The maximum width of these paragraphs
     */

    public void printFormatted(int width) {
        formatParagraphWidth(width);
        printWholeText();
    }

    /**
     * With the "lineSeparator()", a new line can be detected on every System
     * (e.g. in Windows it would be \r\n, in MacOS \n)
     *
     * This method returns a single paragraph with a line break (lineSeparator()) at the given width.
     *
     * @param width position at which a line break is added
     */
    public void formatParagraphWidth (int width){
        for(int paragraphIndex = 0;paragraphIndex<paragraphs.size();paragraphIndex++) {
            String text = paragraphs.get(paragraphIndex);
            int anzahlZeilen = text.length() / width;
            String platzhalter = "";
            int seperatorPlace = width;
            int beginningPlace = 0;
            for (int zeilenIndex = 0; zeilenIndex < anzahlZeilen; zeilenIndex++) {
                if (Character.isWhitespace(text.charAt(seperatorPlace))) {
                    platzhalter = platzhalter + text.substring(beginningPlace, seperatorPlace) + System.lineSeparator();
                    seperatorPlace += width + 1;
                    beginningPlace += width + 1;
                    System.out.println(platzhalter);
                }else {
                    platzhalter = platzhalter + text.substring(beginningPlace, seperatorPlace) + System.lineSeparator();
                    seperatorPlace += width;
                    beginningPlace += width;
                    System.out.println(platzhalter);
                }
            }
            paragraphs.set(paragraphIndex, platzhalter);
            System.out.println(text);
        }
    }
}

