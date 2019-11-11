package ch.zhaw.einhoerner.editor;

import java.util.List;
import java.util.Scanner;

/**
 * The class Processor.
 * <p>
 * <p>
 * //todo Javadoc
 */
public class Processor {

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
        printText(makeWelcomeMesseage());
        printText(makeHelpMesseage());
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

        System.out.println(makeQuitMesseage());
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
     * Prints out a text to the console.
     * @param text A text as String value
     */
    public void printText(String text)
    {
        System.out.println(text);
    }

    /**
     * Creates a welcome message which is used from the method startApplication.
     */

    public String makeWelcomeMesseage() {
        return "Welcome to the Editor Application from the team Einhoerner, please use one of the " +
                "following comands to proceed:";
    }
    /*
    private void printWholeText() {
        for(int i=0;i<paragraphs.size(); i++){
            System.out.println(i+"\t "+paragraphs.get(i));
            System.out.println();
        }
    }
*/
    /**
     * Creates a help message to give the user some advice to use the application.
     * Further information and a manual on how to use the application is on the Wiki-Page of the Github repository
     */
    public String makeHelpMesseage()
    {
        return "Type in " + Command.HELP + " at any time for a short manual.\n\n " +
                "You can choose from the following commands:\n" +
                "add (with or without paragraph number), print, quit, help, searchAndReplace" +
                "(followed by the old and the new word \n\n" +
                "For a manual in detail, please use the Wiki in the Github repository.";
    }

    public String makeQuitMesseage()
    {
        return "Thank you for using the Einhoerner Editor.";
    }

    /**
     * Print out an unformatted version of all the paragraphs
     * @param paragraphs a List of all Paragraphs stored at the time of ececution
     */
    public void printUnformatted(List<String> paragraphs)
    {
        // get list TODO

    }

    /**
     * Print out a formatted version of all the paragraphs
     * @param width - The maximum width of these paragraphs
     */

    public void printFormatted(int width) {
        // TODO List<String> paragraphs;
        // TODO Dekyi
    }
/*
    /**
     * With the "lineSeparator()", a new line can be detected on every System
     * (e.g. in Windows it would be \r\n, in MacOS \n)
     *
     * This method returns a single paragraph with a line break (lineSeparator()) at the given width.
     *
     * @param paragraph paragraph to be formatted
     * @param width position at which a line break is added
     * @return singleParagraph formatted paragraph
     */
/*
    private String formatParagraphWidth (String paragraph, int width){
        List<String> paragraphList = new ArrayList<String>();
        paragraphList.addAll(Arrays.asList(paragraph.split("")));

        String singleParagraph = "";
        width++;

        for (int i = 0; i < paragraphList.size(); i++) {
            if (i % width == 0) {
                paragraphList.add(i, lineSeparator());
            }
            singleParagraph += paragraphList.get(i);
        }

        return singleParagraph;
    }
    */
}

